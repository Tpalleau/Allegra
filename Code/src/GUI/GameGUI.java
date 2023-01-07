package GUI;

import allegra.Card;
import allegra.GameManager;

import tools.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GameGUI extends JFrame
{
	private Container container;
	private GameManager game;
	private List<JPanel> listPlayers;
	private enum Stage {
		CHECKWIN,
		PICKPILE,
		DRAWPILE,
		REPLACE,
		FLIPCARD,
		STEALREPLACE,
		STEALPICK
	}
	Map<Stage, String> StageMessage = new HashMap();

	private Stage currentStage = Stage.PICKPILE;
	private int indexPlayerPlaying = 0;

	private JLabel narrator;
	private JButton endStage;
	private JPanel pilePanels;

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

		tools.setImage(pilePanels.getComponent(1), game.showTopDiscardPile());
	}

	class CardListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton buttonPressed = (JButton) e.getSource();
			int cardIndex = listPlayers.get(indexPlayerPlaying).getComponentZOrder(buttonPressed);
			int[] cardCoord = tools.convert(cardIndex);

			switch (currentStage) {
				case REPLACE, STEALREPLACE, DRAWPILE://all require to replace card
					int cardVal = game.replaceCard(cardCoord[0], cardCoord[1], cardInUse);
					tools.setImage(buttonPressed, cardInUse.getValue());
					tools.setImage(pilePanels.getComponent(1), cardVal);

					if (currentStage == Stage.STEALPICK){
						currentStage = Stage.STEALPICK;
					}else{
						currentStage = Stage.CHECKWIN;
					}
					break;
				case FLIPCARD: // last action in a turn
					tools.setImage(listPlayers.get(indexPlayerPlaying).getComponent(cardIndex), game.FlipCard(cardCoord[0], cardCoord[1]));
					currentStage = Stage.CHECKWIN;
					tools.setEnabled(listPlayers.get(indexPlayerPlaying), false);
					tools.setEnabled(pilePanels, true);
					break;
				case STEALPICK:
					break;
			}	
		}
	}

	class PileListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton pile = (JButton) e.getSource();
			pile.setIcon(null);

			int pileIndex = pilePanels.getComponentZOrder(pile);
			// drawPile -> 0
			// discardPile -> 1

			switch (currentStage) {
				case PICKPILE:
					// pick card from the chosen pile
					cardInUse = game.pickCard(pileIndex);
					System.out.println(cardInUse.getValue()+" from pile"+pileIndex);

					if (pileIndex == 0){// Draw => FlipCard or Replace or Steal
						pile.setEnabled(false);
						currentStage = Stage.DRAWPILE;
					}else{ //discard => REPLACE (deactivate pile)
						tools.setEnabled(pilePanels, false);
						currentStage = Stage.REPLACE;
					}

					// both might replace so activate game matrix
					tools.setEnabled(listPlayers.get(indexPlayerPlaying), true);
					break;

				case DRAWPILE: // equivelent to discarding a card
					assert pileIndex == 1;
					game.discardCard(cardInUse);
					tools.setImage(pile, cardInUse.getValue());
					currentStage = Stage.FLIPCARD;
					break;
				default:
					break;
			}
		}
	}

	// GUI

	private void createScreen(){
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1055,700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.container = this.getContentPane();
	}

	private void pile(){
		pilePanels = new JPanel(new GridLayout(1, 2,20, 0));
		pilePanels.setBounds(451, 296, 64*2+20, 64);


		JButton drawPile = new JButton(new ImageIcon("ressources\\dos.jpg"));
		drawPile.addActionListener(new PileListener());

		JButton discardPile = new JButton();
		discardPile.addActionListener(new PileListener());


		pilePanels.add(drawPile);
		pilePanels.add(discardPile);
		container.add(pilePanels);
	}

	private List<JPanel> drawPlayerButtons(int nbPlayers){
		List<JPanel> playerPanels = new ArrayList<>();
		// coord of panels
		int xPlayerPanel;
		int yPlayerPanel;

		final int CARD_GAP = 10;
		final int CARD_SIZE = 64;
		
		// width and height of the panels
		final int WIDTH_PLAYER = CARD_SIZE*4 + CARD_GAP*3;
		final int HEIGHT_PLAYER = CARD_SIZE*3 + CARD_GAP*2;

		// gap between each JPANEL
		final int PLAYER_GAP = 58;

		//create panel for each player
		for (int playerN = 0; playerN < nbPlayers; playerN++) {
			// calculate panel coord

			// draw right to left
			if (playerN < 3){
				//start x coord: X + distance between each right side panel * n player

				xPlayerPanel = 39 + (WIDTH_PLAYER + PLAYER_GAP)*((playerN)%3);
			}else{
				// draw left to right
				xPlayerPanel = 39 + (WIDTH_PLAYER + PLAYER_GAP)*2 - (WIDTH_PLAYER + PLAYER_GAP)*(playerN - 3);
			}

			if (playerN < 3) {
				yPlayerPanel = 11;
			} else {
				yPlayerPanel = 11 + HEIGHT_PLAYER*2;
			}

			// create card panel
			playerPanels.add(new JPanel(new GridLayout(3, 4, CARD_GAP, CARD_GAP)));
			playerPanels.get(playerN).setBounds(xPlayerPanel, yPlayerPanel, WIDTH_PLAYER, HEIGHT_PLAYER);

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
			drawUI(nbPlayers);
		}

		return playerPanels;
	}
	public void drawUI(int nbPlayers){
		final int VGAP = 210;
		final int HGAP = 131;
		final int WIDTH_UI = 138;
		final int HEIGHT_UI = 31;
		int xUI = 47, yUI = 228;
		for (int playerN = 0; playerN < nbPlayers; playerN++) {
			JPanel UIpanel = new JPanel(new GridLayout(1, 4, 40, 0));
			JLabel name = new JLabel("player"+(playerN+1));
			JLabel pion = new JLabel(new ImageIcon("ressources\\pion.png"));
			
			// shift when changing from top to bottom
			xUI += (playerN == 3) ? 138 : 0;
			yUI = 228 + (HGAP+HEIGHT_UI) * (playerN/3);
			if (playerN < 3){ // top grid UI is on right side
				UIpanel.setBounds(xUI , yUI, WIDTH_UI, HEIGHT_UI);
				xUI += VGAP + WIDTH_UI;

				UIpanel.add(pion);
				UIpanel.add(name);
			}else{ // bottom grid UI is on the left side
				
				xUI -= VGAP + WIDTH_UI;
				UIpanel.setBounds(xUI , yUI, WIDTH_UI, HEIGHT_UI);

				UIpanel.add(name);
				UIpanel.add(pion);
			}
			container.add(UIpanel);
		}
	}
}