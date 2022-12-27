package allegra;

import javax.swing.JFrame;
import javax.swing.JLabel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Menu extends JFrame
{

	public Menu() //création d'une fenetre pour choisir le nombre de joueurs
				  //pour l'instant, appuyer sur un bouton ferme la fenetre et termine le programme
	{
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420,350);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
		
		JLabel labelJoueurs = new JLabel("Choisissez le nombre de joueurs");
		labelJoueurs.setBounds(113, 29, 199, 14);
		getContentPane().add(labelJoueurs);
		
		
		JButton Joueur2 = new JButton("2 joueurs");
		Joueur2.setBounds(68, 101, 89, 23);
		getContentPane().add(Joueur2);
		Joueur2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setFocusable(false);
				dispose();
				System.exit(0);
			}
		});
		
		JButton Joueur3 = new JButton("3 joueurs");
		Joueur3.setBounds(68, 160, 89, 23);
		getContentPane().add(Joueur3);
		Joueur3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFocusable(false);
				dispose();
				System.exit(0);
			}
		});
		
		JButton Joueur4 = new JButton("4 joueurs");
		Joueur4.setBounds(247, 101, 89, 23);
		getContentPane().add(Joueur4);
		Joueur4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setFocusable(false);
				dispose();
				System.exit(0);
			}
		});
		
		JButton Joueur5 = new JButton("5 joueurs");
		Joueur5.setBounds(247, 160, 89, 23);
		getContentPane().add(Joueur5);
		Joueur5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setFocusable(false);
				dispose();
				System.exit(0);
			}
		});
		
		JButton Joueur6 = new JButton("6 joueurs");
		Joueur6.setBounds(159, 220, 89, 23);
		getContentPane().add(Joueur6);
		Joueur6.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setFocusable(false);
				dispose();
				System.exit(0);
			}
		});

	}
	
	public static void main(String[] args) 
	{
		new Menu().setVisible(true);
	}
}
