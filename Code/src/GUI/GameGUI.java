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
		PILEPICKED,
		REPLACE,
		FLIPCARD,
		STEAL,
		STEALPICK
	}
	Map<Stage, String> StageMessage = new HashMap();

	private Stage currentStage = Stage.PICKPILE;
	private int indexPlayerPlaying = 0;

	private JLabel narrator;
	private JPanel pilePanels;

	private Card cardInUse;


	public GameGUI(int nbPlayers)
	{
		// messages
		StageMessage.put(Stage.PICKPILE, "pick a card from a pile P");
		StageMessage.put(Stage.PILEPICKED, "replace with a card or discard it P");
		StageMessage.put(Stage.STEAL, "replace with one of your own");
		StageMessage.put(Stage.STEALPICK, "pick a card you wish to steal");
		StageMessage.put(Stage.REPLACE, "replace with one of your cards");
		StageMessage.put(Stage.FLIPCARD, "pick a card to flip");


		this.createScreen();
		this.pile();
		this.listPlayers = this.drawPlayerButtons(nbPlayers);
		this.game = new GameManager(nbPlayers);
		this.pilePanels.getComponent(1);
	}

	class CardListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton card = (JButton) e.getSource();
			int cardIndex = listPlayers.get(indexPlayerPlaying).getComponentZOrder(card);

			System.out.println(cardIndex);
			switch (currentStage) {
				case PILEPICKED:
					int[] index = ConvertCoord.convert(cardIndex);
					game.replaceCard(index[0], index[1], cardInUse);
					break;
				case REPLACE:
					break;
				case STEAL:
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

			int pileIndex = pilePanels.getComponentZOrder(pile);
			// drawPile -> 0
			// discardPile -> 1

			switch (currentStage) {
				case PICKPILE:
					cardInUse = game.pickCard(pileIndex);
					currentStage = Stage.PILEPICKED;
					if (pileIndex == 0){// if draw then disable draw because can still discard
						pile.setEnabled(false);
						JPanelExtensions.setEnabled(listPlayers.get(indexPlayerPlaying), true);
	
					}else{ // if discard then disable all
						;
						// JPanelExtensions.setEnabled(pilePanels, false);
						JPanelExtensions.setEnabled(listPlayers.get(indexPlayerPlaying), false);
						indexPlayerPlaying = (indexPlayerPlaying+1)%listPlayers.size();
						JPanelExtensions.setEnabled(listPlayers.get(indexPlayerPlaying), true);
					}
					break;

				case PILEPICKED:
					assert pileIndex == 1;
					game.discardCard(cardInUse);
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
		int xUIPanel;
		int yUIPanel;

		final int CARD_GAP = 10;
		final int CARD_SIZE = 64;
		
		// width and height of the panels
		final int WIDTH_PLAYER = CARD_SIZE*4 + CARD_GAP*3;
		final int HEIGHT_PLAYER = CARD_SIZE*3 + CARD_GAP*2;
		final int HEIGHT_UI = 31;

		// gap between each JPANEL
		final int PLAYER_GAP = 58;
		final int YUI_GAP = 131;

		//create panel for each player
		for (int playerN = 0; playerN < nbPlayers; playerN++) {
			// calculate panel coord

			// draw right to left
			if (playerN < 3){
				//start x coord: X + distance between each right side panel * n player

				xPlayerPanel = 39 + (WIDTH_PLAYER + PLAYER_GAP)*((playerN)%3);
				xUIPanel = xPlayerPanel;
			}else{
				// draw left to right
				xPlayerPanel = 39 + (WIDTH_PLAYER + PLAYER_GAP)*2 - (WIDTH_PLAYER + PLAYER_GAP)*(playerN - 3);
				xUIPanel = xPlayerPanel;
			}

			if (playerN < 3) {
				yPlayerPanel = 11;
				yUIPanel = 228;
			} else {
				yPlayerPanel = 11 + HEIGHT_PLAYER*2;
				yUIPanel = 228 + HEIGHT_UI + YUI_GAP;
			}

			// create card panel
			playerPanels.add(new JPanel(new GridLayout(3, 4, CARD_GAP, CARD_GAP)));
			playerPanels.get(playerN).setBounds(xPlayerPanel, yPlayerPanel, WIDTH_PLAYER, HEIGHT_PLAYER);

			// UI panel
			JPanel UIpanel = new JPanel(new GridLayout(1, 4, 40, 0));
			UIpanel.setBounds(xUIPanel, yUIPanel, WIDTH_PLAYER, HEIGHT_UI);

			// add buttons and labels to UI panel
			JButton stealButton = new JButton("voler");
			JLabel lblPion = new JLabel(new ImageIcon("ressources\\pion.png"));
			JLabel lblPlayer = new JLabel("Joueur" + (playerN+1));
			UIpanel.add(stealButton);
			UIpanel.add(lblPlayer);
			UIpanel.add(lblPion);

			// add cards to player panel
			for (int cardN = 0; cardN < 12; ++cardN)
			{
				JButton Button = new JButton(new ImageIcon("ressources\\dos.jpg"));
				Button.addActionListener(new CardListener());
				playerPanels.get(playerN).add(Button);
				container.add(playerPanels.get(playerN));
				container.add(UIpanel);
			}

			// deactivate all cards for 1st turn
			JPanelExtensions.setEnabled(playerPanels.get(playerN), false);
		}

		return playerPanels;
	}
}
