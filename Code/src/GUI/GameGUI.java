package GUI;

import allegra.Card;
import allegra.GameManager;

import tools.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HexFormat;
import java.util.List;
import java.util.Map;

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
		STEALREPLACE,
		STEALPICK
	}
	Map<Stage, String> StageMessage = new HashMap();

	private Stage currentStage = Stage.PICKPILE;
	private int indexPlayerPlaying = 0;

	private List<JPanel> listPlayers;
	private JPanel panelVol;
	private JPanel pilePanel;
	private JButton endButton;
	private JLabel narrator;

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
				cardIndex = listPlayers.get(game.getNeighborIndex()).getComponentZOrder(buttonPressed);
				cardCoord[0] = 4;
				cardCoord[1] = cardIndex/4;
			}else{
				cardCoord = tools.convert(cardIndex);
			}

			switch (currentStage) {
				case REPLACE, STEALREPLACE, DRAWPILE://all require to replace card
					// get value of card replaced to draw it on discard
					System.out.println(cardIndex + " card index");

					int cardVal = game.replaceCard(cardCoord[0], cardCoord[1], cardInUse);

					tools.setImage(buttonPressed, cardInUse.getValue());
					tools.setImage(pilePanel.getComponent(1), cardVal);
					cardInUse = null;

					// check if cards alligned
					int[][] coordCardsToDiscard = game.checkAlligned();
					if (coordCardsToDiscard != null){
						// go through the 3 coords to remove the cards
						for (int i = 0; i < coordCardsToDiscard.length; i++) {

							// convert to JButton coord
							int [] coords = tools.convert(coordCardsToDiscard[i][0], coordCardsToDiscard[i][1]);
							// check if its current player or neighbor table
							if (coords[1] == 1) {
								listPlayers.get(indexPlayerPlaying).getComponent(coords[0]).setVisible(false);
							}else{
								listPlayers.get(game.getNeighborIndex()).getComponent(coords[0]).setVisible(false);
							}
						}
					
					}
					if (currentStage == Stage.STEALPICK){
						currentStage = Stage.STEALREPLACE;
					}else{
						currentStage = Stage.CHECKWIN;
						endButton.setText("End turn");
						endButton.setEnabled(true);
						tools.setEnabled(pilePanel, false);
					}
					break;
				case FLIPCARD: // last action in a turn
					currentStage = Stage.CHECKWIN;
					tools.setImage(buttonPressed, game.FlipCard(cardCoord[0], cardCoord[1]));
					tools.setEnabled(listPlayers.get(indexPlayerPlaying), false);
					tools.setEnabled(listPlayers.get(game.getNeighborIndex()), false);
					tools.setEnabled(pilePanel, false);
					endButton.setEnabled(true);
					endButton.setText("End turn");
					break;
				case STEALPICK:
					break;
				default:
					System.out.println(currentStage + ":current stage");
			}	
			System.out.println(currentStage + ":current stage");

		}
	}

	class PileListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton pile = (JButton) e.getSource();
			pile.setIcon(null);

			int pileIndex = pilePanel.getComponentZOrder(pile);
			// drawPile -> 0
			// discardPile -> 1

			switch (currentStage) {
				case PICKPILE:
					// pick card from the chosen pile
					cardInUse = game.pickCard(pileIndex);

					if (pileIndex == 0){// Draw => FlipCard or Replace or Steal
						tools.setEnabled(pilePanel, false);
						endButton.setEnabled(true);
						endButton.setText("End steal");
						currentStage = Stage.STEAL;
					}else{ //discard => REPLACE (deactivate pile)
						tools.setEnabled(pilePanel, false);
						tools.setPartialDisable(listPlayers.get(game.getNeighborIndex()));
						currentStage = Stage.REPLACE;
					}

					// both might replace so activate game matrix
					tools.setEnabled(listPlayers.get(indexPlayerPlaying), true);
					break;

				case DRAWPILE: // equivelent to discarding a card
					assert pileIndex == 1;
					game.discardCard(cardInUse);
					tools.setImage(pile, cardInUse.getValue());
					tools.setEnabled(pilePanel, false);
					currentStage = Stage.FLIPCARD;
					break;
					
				default:
					System.out.println(currentStage + ":current stage");
					break;
			}
			System.out.println(currentStage + ":current stage");
		}
	}

	class EndListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (currentStage) {
				case CHECKWIN:
					if (game.checkEndGame()){
						System.out.println("Game ended");
					}
					currentStage = Stage.PICKPILE;
					// get index of next player who hasn't played last turn
					tools.setEnabled(listPlayers.get(indexPlayerPlaying), false);
					tools.setEnabled(listPlayers.get(game.getNeighborIndex()), false);
					indexPlayerPlaying = game.nextPlayer();
					tools.setEnabled(pilePanel, true);
					break;
				
				case STEAL:
					currentStage = Stage.DRAWPILE;
					tools.setEnabled(listPlayers.get(indexPlayerPlaying), true);
					tools.setPartialDisable(listPlayers.get(game.getNeighborIndex()));
					pilePanel.getComponent(1).setEnabled(true);

					break;
			
				default:
					System.out.println(currentStage + ":current stage");
					break;
			}
			System.out.println(currentStage + ":current stage");

			// always disabled after clicking end
			endButton.setEnabled(false);
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


		JButton drawPile = new JButton(new ImageIcon("ressources\\dos.jpg"));
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
				JButton Button = new JButton(new ImageIcon("ressources\\dos.jpg"));
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
		final int WIDTH_UI = CARD_SIZE * 2 + CARD_GAP;
		final int HEIGHT_UI = CARD_SIZE;
		final int HGAP = WIDTH_UI + CARD_GAP*2 + CARD_SIZE*2 + PLAYER_GAP;
		final int VGAP = HEIGHT_UI + CARD_SIZE + CARD_GAP;

		int xUI = CARD_GAP;
		int xUI2 = CARD_GAP*4 + CARD_SIZE*3;
		int yUI = CARD_GAP*4 + CARD_SIZE*3;
		for (int playerN = 0; playerN < nbPlayers; playerN++) {

			JPanel volPanel = new JPanel(new GridLayout(1, 1, 0, 0));
			JPanel UIpanel = new JPanel(new GridLayout(1, 2, 40, 0));
			JButton vol = new JButton("Voler");
			JLabel name = new JLabel("player"+(playerN+1));
			JLabel pion = new JLabel(new ImageIcon("ressources\\pion.png"));
			
			// shift when changing from top to bottom
			xUI += (playerN == 3) ? 138 : 0;
			yUI += (playerN == 3) ? VGAP: 0;
			if (playerN < 3){ // top grid UI is on right side
				volPanel.setBounds(xUI , yUI, CARD_SIZE, HEIGHT_UI);
				UIpanel.setBounds(xUI , yUI, WIDTH_UI, HEIGHT_UI);
				xUI += HGAP;

				volPanel.add(vol);
				UIpanel.add(pion);
				UIpanel.add(name);
			}else{ // bottom grid UI is on the left side
				
				xUI -= HGAP;
				volPanel.setBounds(xUI , yUI, CARD_SIZE, HEIGHT_UI);
				UIpanel.setBounds(xUI , yUI, WIDTH_UI, HEIGHT_UI);
				
				volPanel.add(vol);
				UIpanel.add(name);
				UIpanel.add(pion);
			}
			container.add(UIpanel);
			container.add(volPanel);
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