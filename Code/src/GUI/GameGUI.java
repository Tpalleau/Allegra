package GUI;

import allegra.Card;
import allegra.GameManager;

import tools.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HexFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GameGUI extends JFrame
{
	final int CARD_GAP = 10;
	final int CARD_SIZE = 64;
	final int PLAYER_GAP = 30;
	private int[] WindowSize = {CARD_SIZE*12 + CARD_GAP*12 + PLAYER_GAP*2 ,
		CARD_SIZE*9 + CARD_GAP*8 + PLAYER_GAP*2};

	private Container container;
	private GameManager game;
	private enum Stage {
		CHECKWIN,
		PICKPILE,
		DRAWPILE,
		REPLACE,
		FLIPCARD,
		STEAL,
		PICKSTEALER,
		STEALREPLACE,
		STEALPICK
	}
	Map<Stage, String> StageMessage = new HashMap();

	private Stage currentStage = Stage.PICKPILE;
	private int indexPlayerPlaying = 0;
	private int indexStealPlayer;

	private List<JPanel> listPlayers;
	private List<VolListener> listVolListener = new ArrayList<>();
	private JPanel pilePanel;
	private JButton endButton;

	private Card cardInUse;


	public GameGUI(int nbPlayers)
	{
		// messages
		StageMessage.put(Stage.PICKPILE, "pick a card from a pile P");
		StageMessage.put(Stage.DRAWPILE, "replace with a card or discard it P");
		StageMessage.put(Stage.STEALREPLACE, "replace with one of your own P");
		StageMessage.put(Stage.STEALPICK, "pick a card you wish to steal P");
		StageMessage.put(Stage.REPLACE, "replace with one of your cards P");
		StageMessage.put(Stage.FLIPCARD, "pick a card to flip P");


		this.createScreen();
		this.pile();
		this.listPlayers = this.drawPlayerButtons(nbPlayers);
		this.game = new GameManager(nbPlayers);
		drawEnd();

		tools.setImage(pilePanel.getComponent(1), game.showTopDiscardPile());
	}

	class CardListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton buttonPressed = (JButton) e.getSource();
			int cardIndex = listPlayers.get(indexPlayerPlaying).getComponentZOrder(buttonPressed);
			int[] cardCoord = new int[2];
			// if select shared column
			if (cardIndex == -1){
				cardIndex = listPlayers.get(game.getNeighborIndex(indexPlayerPlaying)).getComponentZOrder(buttonPressed);
				cardCoord[0] = 4;
				cardCoord[1] = cardIndex/4;
			}else{
				cardCoord = tools.convert(cardIndex);
			}

			switch (currentStage) {
				case REPLACE, STEALREPLACE, DRAWPILE://all require to replace card
					int indexPlayerReplacing;
					if (currentStage == Stage.STEALPICK){
						currentStage = Stage.STEALREPLACE;
						
						indexPlayerReplacing = indexStealPlayer;
					}else{
						currentStage = Stage.CHECKWIN;

						indexPlayerReplacing = indexPlayerPlaying;
						endButton.setText("End turn");
						endButton.setEnabled(true);
						tools.setEnabled(pilePanel, false);
					}

					int cardVal = game.replaceCard(cardCoord[0], cardCoord[1], cardInUse, indexPlayerReplacing);

					// draw card face down on draw pile
					tools.setImage(pilePanel.getComponent(0), -2);
					
					tools.setImage(buttonPressed, cardInUse.getValue());
					tools.setImage(pilePanel.getComponent(1), cardVal);
					cardInUse = null;

					// check if cards alligned
					int[][] coordCardsToDiscard = game.checkAlligned(indexPlayerReplacing);
					if (coordCardsToDiscard != null){
						// go through the 3 coords to remove the cards
						for (int i = 0; i < coordCardsToDiscard.length; i++) {
							// convert to JButton coord
							int [] coords = tools.convert(coordCardsToDiscard[i][0], coordCardsToDiscard[i][1]);
							// check if its current player or neighbor table
							if (coords[1] == 1) {
								listPlayers.get(indexPlayerReplacing).getComponent(coords[0]).setVisible(false);
							}else{
								listPlayers.get(game.getNeighborIndex(indexPlayerReplacing)).getComponent(coords[0]).setVisible(false);
							}
						}
					
					}
					break;
				case FLIPCARD: // last action in a turn
					currentStage = Stage.CHECKWIN;
					tools.setImage(buttonPressed, game.FlipCard(cardCoord[0], cardCoord[1]));
					tools.setEnabled(listPlayers.get(indexPlayerPlaying), false);
					tools.setEnabled(listPlayers.get(game.getNeighborIndex(indexPlayerPlaying)), false);
					tools.setEnabled(pilePanel, false);
					endButton.setEnabled(true);
					endButton.setText("End turn");
					break;
				case STEALPICK:
					break;
			}	
			System.out.println(currentStage + " + CARDS:current stage");

		}
	}

	class PileListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton pile = (JButton) e.getSource();

			int pileIndex = pilePanel.getComponentZOrder(pile);
			// drawPile -> 0
			// discardPile -> 1

			switch (currentStage) {
				case PICKPILE:
					// pick card from the chosen pile
					cardInUse = game.pickCard(pileIndex);

					if (pileIndex == 0){// Draw => FlipCard or Replace or Steal
						currentStage = Stage.STEAL;
						pilePanel.getComponent(1).setEnabled(false);
						endButton.setEnabled(true);
						endButton.setText("End steal");
						tools.setImage(pile, cardInUse.getValue());
						listVolListener.forEach(v -> v.volButton.setEnabled(true));
					}else{ //discard => REPLACE (deactivate pile)
						tools.setEnabled(pilePanel, false);
						currentStage = Stage.REPLACE;
					}

					// allows player to see their cards but cant interact with them
					tools.setEnabled(listPlayers.get(indexPlayerPlaying), true);
					tools.setPartialDisable(listPlayers.get(game.getNeighborIndex(indexPlayerPlaying)));
					break;

				case DRAWPILE: // equivelent to discarding a card
					if (pileIndex == 1) {
						currentStage = Stage.FLIPCARD;
						tools.setImage(pilePanel.getComponent(0), -2);
						game.discardCard(cardInUse);
						tools.setImage(pilePanel.getComponent(1), cardInUse.getValue());
						tools.setEnabled(pilePanel, false);
					}
					break;
					
				default:
					System.out.println(currentStage + ":current stage");
					break;
			}
			System.out.println(currentStage + " + PILE:current stage");
		}
	}

	class EndListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (currentStage) {
				case CHECKWIN:
					game.checkAllVisible();
					currentStage = Stage.PICKPILE;
					indexPlayerPlaying = game.nextPlayer();
					game.checkAllVisible();
					if (game.checkEndGame()){
						System.out.println("end of game!!!");
					}
					// get index of next player who hasn't played last turn
					tools.setEnabled(listPlayers.get(indexPlayerPlaying), false);
					tools.setEnabled(listPlayers.get(game.getNeighborIndex(indexPlayerPlaying)), false);
					tools.setEnabled(pilePanel, true);
					break;
				
				case STEAL:
					for (VolListener volListener : listVolListener) {
						volListener.volButton.setEnabled(false);
					}
					List<VolListener> steal = listVolListener.stream().filter(v -> v.steal).collect(Collectors.toList()); 
					if (steal.size() != 0){ // player has asked to steal => accept or decline
						currentStage = Stage.PICKSTEALER;
						for (VolListener volListener : steal) {
							volListener.volButton.setEnabled(true);
							volListener.volButton.setText("pick");
						}
						endButton.setText("refuse");
					}else{ // no player wants to steal => replace or discard CardInUse
						currentStage = Stage.DRAWPILE;
						tools.setEnabled(listPlayers.get(indexPlayerPlaying), true);
						tools.setPartialDisable(listPlayers.get(game.getNeighborIndex(indexPlayerPlaying)));
						pilePanel.getComponent(1).setEnabled(true);
						endButton.setEnabled(false);
					}
					break;

				case PICKSTEALER: // steal was refused
					currentStage = Stage.DRAWPILE;
					tools.setEnabled(listPlayers.get(indexPlayerPlaying), true);
					tools.setPartialDisable(listPlayers.get(game.getNeighborIndex(indexPlayerPlaying)));
					pilePanel.getComponent(1).setEnabled(true);
					endButton.setEnabled(false);
					break;
					
			
				default:
					System.out.println(currentStage + ":current stage");
					break;
			}
			System.out.println(currentStage + " + END:current stage");
		}
	}

	class VolListener implements ActionListener{
		private int id;
		private JButton volButton;
		private boolean steal = false;

		public VolListener(int id, JButton button){
			this.id = id;
			this.volButton = button;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (currentStage) {
				case STEAL:
					System.out.println(id+" player is stealing");
					steal = true;
					volButton.setEnabled(false);
					break;
				case PICKSTEALER: // picking stealer
					currentStage = Stage.STEALREPLACE;
					indexStealPlayer = id;
					listVolListener.forEach(v -> v.volButton.setEnabled(false));
					listVolListener.forEach(v -> v.steal = false);
					// deactivate the player playing cards
					tools.setEnabled(listPlayers.get(indexPlayerPlaying), false);
					tools.setEnabled(listPlayers.get(game.getNeighborIndex(indexPlayerPlaying)), false);

					// activate the player stealing cards
					tools.setEnabled(listPlayers.get(indexStealPlayer), true);
					tools.setPartialDisable(listPlayers.get(game.getNeighborIndex(indexStealPlayer)));

				default:
					break;
			}
		}
	}

	// GUI 
	private void createScreen(){
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(WindowSize[0], WindowSize[1]);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.container = this.getContentPane();
	}

	private void pile(){
		int xPile = CARD_GAP*5 + CARD_SIZE*5 + PLAYER_GAP;
		int yPile = CARD_GAP*4 + CARD_SIZE*4;
		pilePanel = new JPanel(new GridLayout(1, 2,CARD_GAP, 0));
		pilePanel.setBounds(xPile, yPile, CARD_SIZE*2 + CARD_GAP, CARD_SIZE);


		JButton drawPile = new JButton(new ImageIcon("ressources\\-2.jpg"));
		drawPile.addActionListener(new PileListener());

		JButton discardPile = new JButton();
		discardPile.addActionListener(new PileListener());


		pilePanel.add(drawPile);
		pilePanel.add(discardPile);
		container.add(pilePanel);
	}

	private List<JPanel> drawPlayerButtons(int nbPlayers){
		List<JPanel> playerPanels = new ArrayList<>();
		// coord of panels
		int xPlayerPanel = CARD_GAP;
		int yPlayerPanel = CARD_GAP;
		
		// width and height of the panels
		final int WIDTH_PLAYER = CARD_SIZE*4 + CARD_GAP*3;
		final int HEIGHT_PLAYER = CARD_SIZE*3 + CARD_GAP*2;

		//create panel for each player
		for (int playerN = 0; playerN < nbPlayers; playerN++) {
			// create card panel
			playerPanels.add(new JPanel(new GridLayout(3, 4, CARD_GAP, CARD_GAP)));

			// shift new coords for next player panel
			yPlayerPanel += (playerN == 3) ? HEIGHT_PLAYER*2 : 0;
			if (playerN < 3){ // draw right to left
				playerPanels.get(playerN).setBounds(xPlayerPanel, yPlayerPanel, WIDTH_PLAYER, HEIGHT_PLAYER);
				xPlayerPanel += (WIDTH_PLAYER + PLAYER_GAP);
			}else{ // draw left to right
				xPlayerPanel -= (WIDTH_PLAYER + PLAYER_GAP);
				playerPanels.get(playerN).setBounds(xPlayerPanel, yPlayerPanel, WIDTH_PLAYER, HEIGHT_PLAYER);
			}			

			// add cards to player panel
			for (int cardN = 0; cardN < 12; ++cardN)
			{
				JButton Button = new JButton(new ImageIcon("ressources\\-2.jpg"));
				Button.addActionListener(new CardListener());
				playerPanels.get(playerN).add(Button);
				container.add(playerPanels.get(playerN));
			}

			// deactivate all cards for 1st turn
			tools.setEnabled(playerPanels.get(playerN), false);
			drawVolUI(nbPlayers);
		}

		return playerPanels;
	}
	public void drawVolUI(int nbPlayers){

		final int WIDTH_UI = CARD_SIZE * 3 + CARD_GAP*2;
		final int HEIGHT_UI = CARD_SIZE;
		final int HGAP = WIDTH_UI + CARD_GAP + CARD_SIZE + PLAYER_GAP;
		final int VGAP = HEIGHT_UI + CARD_SIZE + CARD_GAP*2;

		int xUI = CARD_GAP;
		int yUI = CARD_GAP*3 + CARD_SIZE*3;
		for (int playerN = 0; playerN < nbPlayers; playerN++) {

			JPanel UIpanel = new JPanel(new GridLayout(1, 3, CARD_GAP, 0));
			

			UIpanel.setBounds(xUI, yUI, WIDTH_UI, HEIGHT_UI);
			JLabel name = new JLabel("player"+(playerN+1));
			JLabel pion = new JLabel(new ImageIcon("ressources\\pion.png"));

			JButton vol = new JButton("Vol");
			vol.setEnabled(false);
			VolListener volListener = new VolListener(playerN, vol);
			listVolListener.add(volListener);
			vol.addActionListener(volListener);
			
			// shift when changing from top to bottom
			xUI += (playerN == 3) ? CARD_GAP + CARD_SIZE : 0;
			yUI += (playerN == 3) ? VGAP: 0;
			if (playerN < 3){ // top grid UI is on right side
				UIpanel.setBounds(xUI , yUI, WIDTH_UI, HEIGHT_UI);
				xUI += HGAP;

				UIpanel.add(pion);
				UIpanel.add(name);
				UIpanel.add(vol);
			}else{ // bottom grid UI is on the left side
				
				xUI -= HGAP;
				UIpanel.setBounds(xUI , yUI, WIDTH_UI, HEIGHT_UI);
				
				UIpanel.add(vol);
				UIpanel.add(name);
				UIpanel.add(pion);
			}
			container.add(UIpanel);
		}
	}

	public void drawEnd(){
		int xEnd = CARD_GAP*4 + CARD_SIZE*3 + PLAYER_GAP;
		int yEnd = CARD_GAP*5 + CARD_SIZE * 4;
		endButton = new JButton("END turn");
		endButton.setBounds(xEnd, yEnd, CARD_SIZE*2, CARD_SIZE/2);
		endButton.setEnabled(false);
		endButton.addActionListener(new EndListener());
		container.add(endButton);
	}
}