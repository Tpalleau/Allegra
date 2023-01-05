package GUI;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.util.function.Function;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JToggleButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameGUI extends JFrame
{
	private void createScreen(){
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1055,700);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	private void player1(){
		JLabel lblPionPlayer1 = new JLabel();
		lblPionPlayer1.setIcon(new ImageIcon("ressources\\pion.png"));
		Dimension size = lblPionPlayer1.getPreferredSize();
		lblPionPlayer1.setBounds(57, 228, size.width, size.height);
		getContentPane().add(lblPionPlayer1);


		JLabel lblPlayer1 = new JLabel("Joueur 1");
		lblPlayer1.setBounds(157, 236, 58, 14);
		getContentPane().add(lblPlayer1);

		JButton btnVolPlayer1 = new JButton("Voler");
		btnVolPlayer1.setBounds(261, 233, 64, 23);
		getContentPane().add(btnVolPlayer1);
		btnVolPlayer1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer1_0_0 = new JButton();
		btnPlayer1_0_0.setBounds(39, 11, 64, 64);
		btnPlayer1_0_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer1_0_0);
		btnPlayer1_0_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer1_0_1 = new JButton();
		btnPlayer1_0_1.setBounds(39, 86, 64, 64);
		btnPlayer1_0_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer1_0_1);
		btnPlayer1_0_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnPlayer1_0_2 = new JButton();
		btnPlayer1_0_2.setBounds(39, 161, 64, 64);
		btnPlayer1_0_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer1_0_2);
		btnPlayer1_0_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer1_1_0 = new JButton();
		btnPlayer1_1_0.setBounds(113, 11, 64, 64);
		btnPlayer1_1_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer1_1_0);
		btnPlayer1_1_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer1_1_1 = new JButton();
		btnPlayer1_1_1.setBounds(113, 86, 64, 64);
		btnPlayer1_1_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer1_1_1);
		btnPlayer1_1_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer1_1_2 = new JButton();
		btnPlayer1_1_2.setBounds(113, 161, 64, 64);
		btnPlayer1_1_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer1_1_2);
		btnPlayer1_1_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer1_2_0 = new JButton();
		btnPlayer1_2_0.setBounds(187, 11, 64, 64);
		btnPlayer1_2_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer1_2_0);
		btnPlayer1_2_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer1_2_1 = new JButton();
		btnPlayer1_2_1.setBounds(187, 86, 64, 64);
		btnPlayer1_2_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer1_2_1);
		btnPlayer1_2_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer1_2_2 = new JButton();
		btnPlayer1_2_2.setBounds(187, 161, 64, 64);
		btnPlayer1_2_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer1_2_2);
		btnPlayer1_2_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer1_3_0 = new JButton();
		btnPlayer1_3_0.setBounds(261, 11, 64, 64);
		btnPlayer1_3_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer1_3_0);
		btnPlayer1_3_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer1_3_1 = new JButton();
		btnPlayer1_3_1.setBounds(261, 86, 64, 64);
		btnPlayer1_3_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer1_3_1);
		btnPlayer1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnPlayer1_3_2 = new JButton();
		btnPlayer1_3_2.setBounds(261, 161, 64, 64);
		btnPlayer1_3_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer1_3_2);
		btnPlayer1_3_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});
	}
	private void player2(){
		JLabel lblPionPlayer2 = new JLabel();
		lblPionPlayer2.setIcon(new ImageIcon("ressources\\pion.png"));
		Dimension size = lblPionPlayer2.getPreferredSize();
		lblPionPlayer2.setBounds(395, 228, size.width, size.height);
		getContentPane().add(lblPionPlayer2);

		JLabel lblPlayer2 = new JLabel("Joueur 2");
		lblPlayer2.setBounds(501, 236, 58, 14);
		getContentPane().add(lblPlayer2);

		JButton btnVolPlayer2 = new JButton("Voler");
		btnVolPlayer2.setBounds(599, 233, 64, 23);
		getContentPane().add(btnVolPlayer2);
		btnVolPlayer2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer2_0_0 = new JButton();
		btnPlayer2_0_0.setBounds(377, 11, 64, 64);
		btnPlayer2_0_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer2_0_0);
		btnPlayer2_0_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer2_0_1 = new JButton();
		btnPlayer2_0_1.setBounds(377, 86, 64, 64);
		btnPlayer2_0_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer2_0_1);
		btnPlayer2_0_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer2_0_2 = new JButton();
		btnPlayer2_0_2.setBounds(377, 161, 64, 64);
		btnPlayer2_0_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer2_0_2);
		btnPlayer2_0_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer2_1_0 = new JButton();
		btnPlayer2_1_0.setBounds(451, 11, 64, 64);
		btnPlayer2_1_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer2_1_0);
		btnPlayer2_1_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer2_1_1 = new JButton();
		btnPlayer2_1_1.setBounds(451, 86, 64, 64);
		btnPlayer2_1_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer2_1_1);
		btnPlayer2_1_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer2_1_2 = new JButton();
		btnPlayer2_1_2.setBounds(451, 161, 64, 64);
		btnPlayer2_1_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer2_1_2);
		btnPlayer2_1_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer2_2_0 = new JButton();
		btnPlayer2_2_0.setBounds(525, 11, 64, 64);
		btnPlayer2_2_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer2_2_0);
		btnPlayer2_2_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer2_2_1 = new JButton();
		btnPlayer2_2_1.setBounds(525, 86, 64, 64);
		btnPlayer2_2_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer2_2_1);
		btnPlayer2_2_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer2_2_2 = new JButton();
		btnPlayer2_2_2.setBounds(525, 161, 64, 64);
		btnPlayer2_2_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer2_2_2);
		btnPlayer2_2_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer2_3_0 = new JButton();
		btnPlayer2_3_0.setBounds(599, 11, 64, 64);
		btnPlayer2_3_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer2_3_0);
		btnPlayer2_3_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});


		JButton btnPlayer2_3_1 = new JButton();
		btnPlayer2_3_1.setBounds(599, 86, 64, 64);
		btnPlayer2_3_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer2_3_1);
		btnPlayer2_3_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer2_3_2 = new JButton();
		btnPlayer2_3_2.setBounds(599, 161, 64, 64);
		btnPlayer2_3_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer2_3_2);
		btnPlayer2_3_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});
	}
	private void player3(){
		JLabel lblPionPlayer3 = new JLabel();
		lblPionPlayer3.setIcon(new ImageIcon("ressources\\pion.png"));
		Dimension size = lblPionPlayer3.getPreferredSize();
		lblPionPlayer3.setBounds(734, 228, size.width, size.height);
		getContentPane().add(lblPionPlayer3);


		JLabel lblPlayer3 = new JLabel("Joueur 3");
		lblPlayer3.setBounds(834, 236, 58, 14);
		getContentPane().add(lblPlayer3);

		JButton btnVolPlayer3 = new JButton("Voler");
		btnVolPlayer3.setBounds(938, 233, 64, 23);
		getContentPane().add(btnVolPlayer3);
		btnVolPlayer3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer3_0_0 = new JButton();
		btnPlayer3_0_0.setBounds(716, 11, 64, 64);
		btnPlayer3_0_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer3_0_0);
		btnPlayer3_0_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer3_0_1 = new JButton();
		btnPlayer3_0_1.setBounds(716, 86, 64, 64);
		btnPlayer3_0_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer3_0_1);
		btnPlayer3_0_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer3_0_2 = new JButton();
		btnPlayer3_0_2.setBounds(716, 161, 64, 64);
		btnPlayer3_0_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer3_0_2);
		btnPlayer3_0_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer3_1_0 = new JButton();
		btnPlayer3_1_0.setBounds(790, 11, 64, 64);
		btnPlayer3_1_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer3_1_0);
		btnPlayer3_1_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer3_1_1 = new JButton();
		btnPlayer3_1_1.setBounds(790, 86, 64, 64);
		btnPlayer3_1_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer3_1_1);
		btnPlayer3_1_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer3_1_2 = new JButton();
		btnPlayer3_1_2.setBounds(790, 161, 64, 64);
		btnPlayer3_1_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer3_1_2);
		btnPlayer3_1_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer3_2_0 = new JButton();
		btnPlayer3_2_0.setBounds(864, 11, 64, 64);
		btnPlayer3_2_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer3_2_0);
		btnPlayer3_2_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer3_2_1 = new JButton();
		btnPlayer3_2_1.setBounds(864, 86, 64, 64);
		btnPlayer3_2_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer3_2_1);
		btnPlayer3_2_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer3_2_2 = new JButton();
		btnPlayer3_2_2.setBounds(864, 161, 64, 64);
		btnPlayer3_2_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer3_2_2);
		btnPlayer3_2_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer3_3_0 = new JButton();
		btnPlayer3_3_0.setBounds(938, 11, 64, 64);
		btnPlayer3_3_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer3_3_0);
		btnPlayer3_3_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer3_3_1 = new JButton();
		btnPlayer3_3_1.setBounds(938, 86, 64, 64);
		btnPlayer3_3_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer3_3_1);
		btnPlayer3_3_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer3_3_2 = new JButton();
		btnPlayer3_3_2.setBounds(938, 161, 64, 64);
		btnPlayer3_3_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer3_3_2);
		btnPlayer3_3_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});
	}
	private void player4(){
		JLabel lblPionPlayer4 = new JLabel();
		lblPionPlayer4.setIcon(new ImageIcon("ressources\\pion.png"));
		Dimension size = lblPionPlayer4.getPreferredSize();
		lblPionPlayer4.setBounds(956, 390, size.width, size.height);
		getContentPane().add(lblPionPlayer4);


		JLabel lblPlayer4 = new JLabel("Joueur 4");
		lblPlayer4.setBounds(834, 411, 58, 14);
		getContentPane().add(lblPlayer4);

		JButton btnVolPlayer4 = new JButton("Voler");
		btnVolPlayer4.setBounds(716, 405, 64, 23);
		getContentPane().add(btnVolPlayer4);
		btnVolPlayer4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer4_0_0 = new JButton();
		btnPlayer4_0_0.setBounds(716, 436, 64, 64);
		btnPlayer4_0_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer4_0_0);
		btnPlayer4_0_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer4_0_1 = new JButton();
		btnPlayer4_0_1.setBounds(716, 511, 64, 64);
		btnPlayer4_0_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer4_0_1);
		btnPlayer4_0_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer4_0_2 = new JButton();
		btnPlayer4_0_2.setBounds(716, 586, 64, 64);
		btnPlayer4_0_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer4_0_2);
		btnPlayer4_0_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer4_1_0 = new JButton();
		btnPlayer4_1_0.setBounds(790, 436, 64, 64);
		btnPlayer4_1_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer4_1_0);
		btnPlayer4_1_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer4_1_1 = new JButton();
		btnPlayer4_1_1.setBounds(790, 511, 64, 64);
		btnPlayer4_1_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer4_1_1);
		btnPlayer4_1_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer4_1_2 = new JButton();
		btnPlayer4_1_2.setBounds(790, 586, 64, 64);
		btnPlayer4_1_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer4_1_2);
		btnPlayer4_1_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer4_2_0 = new JButton();
		btnPlayer4_2_0.setBounds(864, 436, 64, 64);
		btnPlayer4_2_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer4_2_0);
		btnPlayer4_2_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer4_2_1 = new JButton();
		btnPlayer4_2_1.setBounds(864, 511, 64, 64);
		btnPlayer4_2_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer4_2_1);
		btnPlayer4_2_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer4_2_2 = new JButton();
		btnPlayer4_2_2.setBounds(864, 586, 64, 64);
		btnPlayer4_2_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer4_2_2);
		btnPlayer4_2_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer4_3_0 = new JButton();
		btnPlayer4_3_0.setBounds(938, 436, 64, 64);
		btnPlayer4_3_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer4_3_0);
		btnPlayer4_3_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer4_3_1 = new JButton();
		btnPlayer4_3_1.setBounds(938, 511, 64, 64);
		btnPlayer4_3_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer4_3_1);
		btnPlayer4_3_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer4_3_2 = new JButton();
		btnPlayer4_3_2.setBounds(938, 586, 64, 64);
		btnPlayer4_3_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer4_3_2);
		btnPlayer4_3_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});
	}
	private void player5(){
		JLabel lblPionPlayer5 = new JLabel();
		lblPionPlayer5.setIcon(new ImageIcon("ressources\\pion.png"));
		Dimension size = lblPionPlayer5.getPreferredSize();
		lblPionPlayer5.setBounds(617, 390, size.width, size.height);
		getContentPane().add(lblPionPlayer5);

		JLabel lblPlayer5 = new JLabel("Joueur 5");
		lblPlayer5.setBounds(501, 411, 58, 14);
		getContentPane().add(lblPlayer5);

		JButton btnVolPlayer5 = new JButton("Voler");
		btnVolPlayer5.setBounds(377, 405, 64, 23);
		getContentPane().add(btnVolPlayer5);
		btnVolPlayer5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){}
		});

		JButton btnPlayer5_0_0 = new JButton();
		btnPlayer5_0_0.setBounds(377, 436, 64, 64);
		btnPlayer5_0_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer5_0_0);
		btnPlayer5_0_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});


		JButton btnPlayer5_0_1 = new JButton();
		btnPlayer5_0_1.setBounds(377, 511, 64, 64);
		btnPlayer5_0_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer5_0_1);
		btnPlayer5_0_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer5_0_2 = new JButton();
		btnPlayer5_0_2.setBounds(377, 586, 64, 64);
		btnPlayer5_0_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer5_0_2);
		btnPlayer5_0_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer5_1_0 = new JButton();
		btnPlayer5_1_0.setBounds(451, 436, 64, 64);
		btnPlayer5_1_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer5_1_0);
		btnPlayer5_1_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer5_1_1 = new JButton();
		btnPlayer5_1_1.setBounds(451, 511, 64, 64);
		btnPlayer5_1_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer5_1_1);
		btnPlayer5_1_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer5_1_2 = new JButton();
		btnPlayer5_1_2.setBounds(451, 586, 64, 64);
		btnPlayer5_1_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer5_1_2);
		btnPlayer5_1_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer5_2_0 = new JButton();
		btnPlayer5_2_0.setBounds(525, 436, 64, 64);
		btnPlayer5_2_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer5_2_0);
		btnPlayer5_2_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer5_2_1 = new JButton();
		btnPlayer5_2_1.setBounds(525, 511, 64, 64);
		btnPlayer5_2_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer5_2_1);
		btnPlayer5_2_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer5_2_2 = new JButton();
		btnPlayer5_2_2.setBounds(525, 586, 64, 64);
		btnPlayer5_2_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer5_2_2);
		btnPlayer5_2_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer5_3_0 = new JButton();
		btnPlayer5_3_0.setBounds(599, 436, 64, 64);
		btnPlayer5_3_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer5_3_0);
		btnPlayer5_3_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer5_3_1 = new JButton();
		btnPlayer5_3_1.setBounds(599, 511, 64, 64);
		btnPlayer5_3_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer5_3_1);
		btnPlayer5_3_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer5_3_2 = new JButton();
		btnPlayer5_3_2.setBounds(599, 586, 64, 64);
		btnPlayer5_3_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer5_3_2);
		btnPlayer5_3_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});
	}
	private void player6(){
		JLabel lblPionPlayer6 = new JLabel();
		lblPionPlayer6.setIcon(new ImageIcon("ressources\\pion.png"));
		Dimension size = lblPionPlayer6.getPreferredSize();
		lblPionPlayer6.setBounds(280, 390, size.width, size.height);
		getContentPane().add(lblPionPlayer6);

		JLabel lblPlayer6 = new JLabel("Joueur 6");
		lblPlayer6.setBounds(157, 411, 58, 14);
		getContentPane().add(lblPlayer6);

		JButton btnVolPlayer6 = new JButton("Voler");
		btnVolPlayer6.setBounds(39, 405, 64, 23);
		getContentPane().add(btnVolPlayer6);
		btnVolPlayer6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){}
		});

		JButton btnPlayer6_0_0 = new JButton();
		btnPlayer6_0_0.setBounds(39, 436, 64, 64);
		btnPlayer6_0_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer6_0_0);
		btnPlayer6_0_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){}
		});

		JButton btnPlayer6_0_1 = new JButton();
		btnPlayer6_0_1.setBounds(39, 511, 64, 64);
		btnPlayer6_0_1.setIcon(new ImageIcon("ressources\\dos.jpg"));;
		getContentPane().add(btnPlayer6_0_1);
		btnPlayer6_0_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){}
		});

		JButton btnPlayer6_0_2 = new JButton(); // les boutons sont appele btnPlayerNumJoueur_numColomne_numLigne
		btnPlayer6_0_2.setBounds(39, 586, 64, 64);
		btnPlayer6_0_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer6_0_2);
		btnPlayer6_0_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer6_1_0 = new JButton();
		btnPlayer6_1_0.setBounds(113, 436, 64, 64);
		btnPlayer6_1_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer6_1_0);
		btnPlayer6_1_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer6_1_1 = new JButton();
		btnPlayer6_1_1.setBounds(113, 511, 64, 64);
		btnPlayer6_1_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer6_1_1);
		btnPlayer6_1_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer6_1_2 = new JButton();
		btnPlayer6_1_2.setBounds(113, 586, 64, 64);
		btnPlayer6_1_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer6_1_2);
		btnPlayer6_1_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer6_2_0 = new JButton();
		btnPlayer6_2_0.setBounds(187, 436, 64, 64);
		btnPlayer6_2_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer6_2_0);
		btnPlayer6_2_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer6_2_1 = new JButton();
		btnPlayer6_2_1.setBounds(187, 511, 64, 64);
		btnPlayer6_2_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer6_2_1);
		btnPlayer6_2_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer6_2_2 = new JButton();
		btnPlayer6_2_2.setBounds(187, 586, 64, 64);
		btnPlayer6_2_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer6_2_2);
		btnPlayer6_2_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{}
		});

		JButton btnPlayer6_3_0 = new JButton();
		btnPlayer6_3_0.setBounds(261, 436, 64, 64);
		btnPlayer6_3_0.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer6_3_0);
		btnPlayer6_3_0.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{}
		});

		JButton btnPlayer6_3_1 = new JButton();
		btnPlayer6_3_1.setBounds(261, 511, 64, 64);
		btnPlayer6_3_1.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer6_3_1);
		btnPlayer6_3_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

		JButton btnPlayer6_3_2 = new JButton();
		btnPlayer6_3_2.setBounds(261, 586, 64, 64);
		btnPlayer6_3_2.setIcon(new ImageIcon("ressources\\dos.jpg"));
		getContentPane().add(btnPlayer6_3_2);
		btnPlayer6_3_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {}
		});

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
	 public GameGUI(int nbJoueur)
	 {
		this.createScreen();
		this.player1();
		switch (nbJoueur) {
			case 6:
				this.player6();
			case 5:
				this.player5();
			case 4:
				this.player4();
			case 3:
				this.player3();
			case 2:
				this.player2();
			default:
				pile();
		}
	 }
}
