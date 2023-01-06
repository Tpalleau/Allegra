package GUI;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JToggleButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Container;

public class GameGUI extends JFrame
{
	private Container container;

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
		JButton btnDeck = new JButton();
		btnDeck.setBounds(451, 296, 64, 64);
		btnDeck.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnDeck);
		btnDeck.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

			}
		});

		JButton btnDefausse = new JButton();
		btnDefausse.setBounds(525, 296, 64, 64);
		getContentPane().add(btnDefausse);
		btnDefausse.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

			}
		});
	}

	private List<JPanel> playerButtonsDraw(int nbPlayers){
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
				playerPanels.get(playerN).add(Button);
				container.add(playerPanels.get(playerN));
				container.add(UIpanel);
			}
		}

		return playerPanels;
	}

	public GameGUI(int nbPlayers)
	{
		this.createScreen();
		this.pile();
		List<JPanel> playerPanels = this.playerButtonsDraw(nbPlayers);
	}
}
