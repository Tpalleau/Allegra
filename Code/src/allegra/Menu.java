package allegra;

import javax.swing.JFrame;
import javax.swing.JLabel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Menu extends JFrame
{

	public Menu() //cr�ation d'une fenetre pour choisir le nombre de joueurs
	{
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420,350);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
		
		JLabel labelJoueurs = new JLabel("Choisissez le nombre de joueurs");
		labelJoueurs.setBounds(113, 29, 199, 14);
		getContentPane().add(labelJoueurs);
		
		
		JButton joueur2 = new JButton("2 joueurs");
		joueur2.setBounds(68, 101, 89, 23);
		getContentPane().add(joueur2);
		joueur2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setFocusable(false);
				new GameGUI(2).setVisible(true);
				dispose();
			}
		});
		
		JButton joueur3 = new JButton("3 joueurs");
		joueur3.setBounds(68, 160, 89, 23);
		getContentPane().add(joueur3);
		joueur3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setFocusable(false);
				new GameGUI(3).setVisible(true);
				dispose();
			}
		});
		
		JButton joueur4 = new JButton("4 joueurs");
		joueur4.setBounds(247, 101, 89, 23);
		getContentPane().add(joueur4);
		joueur4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setFocusable(false);
				new GameGUI(4).setVisible(true);
				dispose();
			}
		});
		
		JButton joueur5 = new JButton("5 joueurs");
		joueur5.setBounds(247, 160, 89, 23);
		getContentPane().add(joueur5);
		joueur5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setFocusable(false);
				new GameGUI(5).setVisible(true);
				dispose();

			}
		});
		
		JButton joueur6 = new JButton("6 joueurs");
		joueur6.setBounds(159, 220, 89, 23);
		getContentPane().add(joueur6);
		joueur6.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setFocusable(false);
				new GameGUI(6).setVisible(true);
				dispose();
			}
		});

	}
	
	public static void main(String[] args) 
	{
		new Menu().setVisible(true);
	}
}
