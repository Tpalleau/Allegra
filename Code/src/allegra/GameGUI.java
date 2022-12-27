package allegra;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;

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

	 public GameGUI () 
	 {
		 	getContentPane().setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setSize(1055,700);
	        this.setLocationRelativeTo(null);
	        
		 	JButton btnPlayer1_0_0 = new JButton();
		 	btnPlayer1_0_0.setBounds(39, 436, 64, 64);
		 	getContentPane().add(btnPlayer1_0_0);
		 	btnPlayer1_0_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer1_0_1 = new JButton();
		 	btnPlayer1_0_1.setBounds(39, 511, 64, 64);
		 	getContentPane().add(btnPlayer1_0_1);
		 	btnPlayer1_0_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer1_0_2 = new JButton(); // les boutons sont appelés btnPlayerNumJoueur_numColomne_numLigne
		 	btnPlayer1_0_2.setBounds(39, 586, 64, 64);
		 	getContentPane().add(btnPlayer1_0_2);
		 	btnPlayer1_0_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer1_1_0 = new JButton();
		 	btnPlayer1_1_0.setBounds(113, 436, 64, 64);
		 	getContentPane().add(btnPlayer1_1_0);
		 	btnPlayer1_1_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer1_1_1 = new JButton();
		 	btnPlayer1_1_1.setBounds(113, 511, 64, 64);
		 	getContentPane().add(btnPlayer1_1_1);
		 	btnPlayer1_1_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer1_1_2 = new JButton();
		 	btnPlayer1_1_2.setBounds(113, 586, 64, 64);
		 	getContentPane().add(btnPlayer1_1_2);
		 	btnPlayer1_1_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer1_2_0 = new JButton();
		 	btnPlayer1_2_0.setBounds(187, 436, 64, 64);
		 	getContentPane().add(btnPlayer1_2_0);
		 	btnPlayer1_2_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer1_2_1 = new JButton();
		 	btnPlayer1_2_1.setBounds(187, 511, 64, 64);
		 	getContentPane().add(btnPlayer1_2_1);
		 	btnPlayer1_2_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer1_2_2 = new JButton();
		 	btnPlayer1_2_2.setBounds(187, 586, 64, 64);
		 	getContentPane().add(btnPlayer1_2_2);
		 	btnPlayer1_2_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer1_3_0 = new JButton();
		 	btnPlayer1_3_0.setBounds(261, 436, 64, 64);
		 	getContentPane().add(btnPlayer1_3_0);
		 	btnPlayer1_3_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer1_3_1 = new JButton();
		 	btnPlayer1_3_1.setBounds(261, 511, 64, 64);
		 	getContentPane().add(btnPlayer1_3_1);
		 	btnPlayer1_3_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer1_3_2 = new JButton();
		 	btnPlayer1_3_2.setBounds(261, 586, 64, 64);
		 	getContentPane().add(btnPlayer1_3_2);
		 	btnPlayer1_3_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	//joueur 2

		 	JButton btnPlayer2_0_0 = new JButton();
		 	getContentPane().add(btnPlayer2_0_0);
		 	btnPlayer2_0_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	btnPlayer2_0_0.setBounds(377, 436, 64, 64);
		 	
		 	JButton btnPlayer2_0_1 = new JButton();
		 	btnPlayer2_0_1.setBounds(377, 511, 64, 64);
		 	getContentPane().add(btnPlayer2_0_1);
		 	btnPlayer2_0_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});

		 	JButton btnPlayer2_0_2 = new JButton();
		 	btnPlayer2_0_2.setBounds(377, 586, 64, 64);
		 	getContentPane().add(btnPlayer2_0_2);
		 	btnPlayer2_0_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer2_1_0 = new JButton();
		 	btnPlayer2_1_0.setBounds(451, 436, 64, 64);
		 	getContentPane().add(btnPlayer2_1_0);
		 	btnPlayer2_1_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer2_1_1 = new JButton();
		 	btnPlayer2_1_1.setBounds(451, 511, 64, 64);
		 	getContentPane().add(btnPlayer2_1_1);
		 	btnPlayer2_1_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer2_1_2 = new JButton();
		 	btnPlayer2_1_2.setBounds(451, 586, 64, 64);
		 	getContentPane().add(btnPlayer2_1_2);
		 	btnPlayer2_1_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});

		 	JButton btnPlayer2_2_0 = new JButton();
		 	btnPlayer2_2_0.setBounds(525, 436, 64, 64);
		 	getContentPane().add(btnPlayer2_2_0);
		 	btnPlayer2_2_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer2_2_1 = new JButton();
		 	btnPlayer2_2_1.setBounds(525, 511, 64, 64);
		 	getContentPane().add(btnPlayer2_2_1);
		 	btnPlayer2_2_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer2_2_2 = new JButton();
		 	btnPlayer2_2_2.setBounds(525, 586, 64, 64);
		 	getContentPane().add(btnPlayer2_2_2);
		 	btnPlayer2_2_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer2_3_0 = new JButton();
		 	btnPlayer2_3_0.setBounds(599, 436, 64, 64);
		 	getContentPane().add(btnPlayer2_3_0);
		 	btnPlayer2_3_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer2_3_1 = new JButton();
		 	btnPlayer2_3_1.setBounds(599, 511, 64, 64);
		 	getContentPane().add(btnPlayer2_3_1);
		 	btnPlayer2_3_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer2_3_2 = new JButton();
		 	btnPlayer2_3_2.setBounds(599, 586, 64, 64);
		 	getContentPane().add(btnPlayer2_3_2);
		 	btnPlayer2_3_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});

		 	//joueur 3
		 	
		 	JButton btnPlayer3_0_0 = new JButton();
		 	btnPlayer3_0_0.setBounds(716, 436, 64, 64);
		 	getContentPane().add(btnPlayer3_0_0);
		 	btnPlayer3_0_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer3_0_1 = new JButton();
		 	btnPlayer3_0_1.setBounds(716, 511, 64, 64);
		 	getContentPane().add(btnPlayer3_0_1);
		 	btnPlayer3_0_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer3_0_2 = new JButton();
		 	btnPlayer3_0_2.setBounds(716, 586, 64, 64);
		 	getContentPane().add(btnPlayer3_0_2);
		 	btnPlayer3_0_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer3_1_0 = new JButton();
		 	btnPlayer3_1_0.setBounds(790, 436, 64, 64);
		 	getContentPane().add(btnPlayer3_1_0);
		 	btnPlayer3_1_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer3_1_1 = new JButton();
		 	btnPlayer3_1_1.setBounds(790, 511, 64, 64);
		 	getContentPane().add(btnPlayer3_1_1);
		 	btnPlayer3_1_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer3_1_2 = new JButton();
		 	btnPlayer3_1_2.setBounds(790, 586, 64, 64);
		 	getContentPane().add(btnPlayer3_1_2);
		 	btnPlayer3_1_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer3_2_0 = new JButton();
		 	btnPlayer3_2_0.setBounds(864, 436, 64, 64);
		 	getContentPane().add(btnPlayer3_2_0);
		 	btnPlayer3_2_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer3_2_1 = new JButton();
		 	btnPlayer3_2_1.setBounds(864, 511, 64, 64);
		 	getContentPane().add(btnPlayer3_2_1);
		 	btnPlayer3_2_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer3_2_2 = new JButton();
		 	btnPlayer3_2_2.setBounds(864, 586, 64, 64);
		 	getContentPane().add(btnPlayer3_2_2);
		 	btnPlayer3_2_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});

		 	JButton btnPlayer3_3_0 = new JButton();
		 	btnPlayer3_3_0.setBounds(938, 436, 64, 64);
		 	getContentPane().add(btnPlayer3_3_0);
		 	btnPlayer3_3_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer3_3_1 = new JButton();
		 	btnPlayer3_3_1.setBounds(938, 511, 64, 64);
		 	getContentPane().add(btnPlayer3_3_1);
		 	btnPlayer3_3_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer3_3_2 = new JButton();
		 	btnPlayer3_3_2.setBounds(938, 586, 64, 64);
		 	getContentPane().add(btnPlayer3_3_2);
		 	btnPlayer3_3_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	//joueur 4
		 	
		 	JButton btnPlayer4_0_0 = new JButton();
		 	btnPlayer4_0_0.setBounds(716, 11, 64, 64);
		 	getContentPane().add(btnPlayer4_0_0);
		 	btnPlayer4_0_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer4_0_1 = new JButton();
		 	btnPlayer4_0_1.setBounds(716, 86, 64, 64);
		 	getContentPane().add(btnPlayer4_0_1);
		 	btnPlayer4_0_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer4_0_2 = new JButton();
		 	btnPlayer4_0_2.setBounds(716, 161, 64, 64);
		 	getContentPane().add(btnPlayer4_0_2);
		 	btnPlayer4_0_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer4_1_0 = new JButton();
		 	btnPlayer4_1_0.setBounds(790, 11, 64, 64);
		 	getContentPane().add(btnPlayer4_1_0);
		 	btnPlayer4_1_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer4_1_1 = new JButton();
		 	btnPlayer4_1_1.setBounds(790, 86, 64, 64);
		 	getContentPane().add(btnPlayer4_1_1);
		 	btnPlayer4_1_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});

		 	JButton btnPlayer4_1_2 = new JButton();
		 	btnPlayer4_1_2.setBounds(790, 161, 64, 64);
		 	getContentPane().add(btnPlayer4_1_2);
		 	btnPlayer4_1_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer4_2_0 = new JButton();
		 	btnPlayer4_2_0.setBounds(864, 11, 64, 64);
		 	getContentPane().add(btnPlayer4_2_0);
		 	btnPlayer4_2_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer4_2_1 = new JButton();
		 	btnPlayer4_2_1.setBounds(864, 86, 64, 64);
		 	getContentPane().add(btnPlayer4_2_1);
		 	btnPlayer4_2_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer4_2_2 = new JButton();
		 	btnPlayer4_2_2.setBounds(864, 161, 64, 64);
		 	getContentPane().add(btnPlayer4_2_2);
		 	btnPlayer4_2_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer4_3_0 = new JButton();
		 	btnPlayer4_3_0.setBounds(938, 11, 64, 64);
		 	getContentPane().add(btnPlayer4_3_0);
		 	btnPlayer4_3_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer4_3_1 = new JButton();
		 	btnPlayer4_3_1.setBounds(938, 86, 64, 64);
		 	getContentPane().add(btnPlayer4_3_1);
		 	btnPlayer4_3_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer4_3_2 = new JButton();
		 	btnPlayer4_3_2.setBounds(938, 161, 64, 64);
		 	getContentPane().add(btnPlayer4_3_2);
		 	btnPlayer4_3_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	//joueur 5
		 	
		 	
		 	JButton btnPlayer5_0_0 = new JButton();
		 	btnPlayer5_0_0.setBounds(377, 11, 64, 64);
		 	getContentPane().add(btnPlayer5_0_0);
		 	btnPlayer5_0_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer5_0_1 = new JButton();
		 	btnPlayer5_0_1.setBounds(377, 86, 64, 64);
		 	getContentPane().add(btnPlayer5_0_1);
		 	btnPlayer5_0_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});

		 	JButton btnPlayer5_0_2 = new JButton();
		 	btnPlayer5_0_2.setBounds(377, 161, 64, 64);
		 	getContentPane().add(btnPlayer5_0_2);
		 	btnPlayer5_0_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer5_1_0 = new JButton();
		 	btnPlayer5_1_0.setBounds(451, 11, 64, 64);
		 	getContentPane().add(btnPlayer5_1_0);
		 	btnPlayer5_1_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer5_1_1 = new JButton();
		 	btnPlayer5_1_1.setBounds(451, 86, 64, 64);
		 	getContentPane().add(btnPlayer5_1_1);
		 	btnPlayer5_1_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer5_1_2 = new JButton();
		 	btnPlayer5_1_2.setBounds(451, 161, 64, 64);
		 	getContentPane().add(btnPlayer5_1_2);
		 	btnPlayer5_1_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer5_2_0 = new JButton();
		 	btnPlayer5_2_0.setBounds(525, 11, 64, 64);
		 	getContentPane().add(btnPlayer5_2_0);
		 	btnPlayer5_2_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer5_2_1 = new JButton();
		 	btnPlayer5_2_1.setBounds(525, 86, 64, 64);
		 	getContentPane().add(btnPlayer5_2_1);
		 	btnPlayer5_2_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer5_2_2 = new JButton();
		 	btnPlayer5_2_2.setBounds(525, 161, 64, 64);
		 	getContentPane().add(btnPlayer5_2_2);
		 	btnPlayer5_2_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer5_3_0 = new JButton();
		 	btnPlayer5_3_0.setBounds(599, 11, 64, 64);
		 	getContentPane().add(btnPlayer5_3_0);
		 	btnPlayer5_3_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	
		 	JButton btnPlayer5_3_1 = new JButton();
		 	btnPlayer5_3_1.setBounds(599, 86, 64, 64);
		 	getContentPane().add(btnPlayer5_3_1);
		 	btnPlayer5_3_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer5_3_2 = new JButton();
		 	btnPlayer5_3_2.setBounds(599, 161, 64, 64);
		 	getContentPane().add(btnPlayer5_3_2);
		 	btnPlayer5_3_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	//joueur 6
		 	
		 	JButton btnPlayer6_0_0 = new JButton();
		 	btnPlayer6_0_0.setBounds(39, 11, 64, 64);
		 	getContentPane().add(btnPlayer6_0_0);
		 	btnPlayer6_0_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer6_0_1 = new JButton();
		 	btnPlayer6_0_1.setBounds(39, 86, 64, 64);
		 	getContentPane().add(btnPlayer6_0_1);
		 	btnPlayer6_0_1.addActionListener(new ActionListener() {
		 		public void actionPerformed(ActionEvent e) {
		 		}
		 	});
		 	
		 	JButton btnPlayer6_0_2 = new JButton();
		 	btnPlayer6_0_2.setBounds(39, 161, 64, 64);
		 	getContentPane().add(btnPlayer6_0_2);
		 	btnPlayer6_0_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer6_1_0 = new JButton();
		 	btnPlayer6_1_0.setBounds(113, 11, 64, 64);
		 	getContentPane().add(btnPlayer6_1_0);
		 	btnPlayer6_1_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer6_1_1 = new JButton();
		 	btnPlayer6_1_1.setBounds(113, 86, 64, 64);
		 	getContentPane().add(btnPlayer6_1_1);
		 	btnPlayer6_1_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer6_1_2 = new JButton();
		 	btnPlayer6_1_2.setBounds(113, 161, 64, 64);
		 	getContentPane().add(btnPlayer6_1_2);
		 	btnPlayer6_1_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer6_2_0 = new JButton();
		 	btnPlayer6_2_0.setBounds(187, 11, 64, 64);
		 	getContentPane().add(btnPlayer6_2_0);
		 	btnPlayer6_2_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer6_2_1 = new JButton();
		 	btnPlayer6_2_1.setBounds(187, 86, 64, 64);
		 	getContentPane().add(btnPlayer6_2_1);
		 	btnPlayer6_2_1.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer6_2_2 = new JButton();
		 	btnPlayer6_2_2.setBounds(187, 161, 64, 64);
		 	getContentPane().add(btnPlayer6_2_2);
		 	btnPlayer6_2_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer6_3_0 = new JButton();
		 	btnPlayer6_3_0.setBounds(261, 11, 64, 64);
		 	getContentPane().add(btnPlayer6_3_0);
		 	btnPlayer6_3_0.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	JButton btnPlayer6_3_1 = new JButton();
		 	btnPlayer6_3_1.setBounds(261, 86, 64, 64);
		 	getContentPane().add(btnPlayer6_3_1);
		 	btnPlayer6_3_1.addActionListener(new ActionListener() {
		 		public void actionPerformed(ActionEvent e) {
		 		}
		 	});
		 	
		 	JButton btnPlayer6_3_2 = new JButton();
		 	btnPlayer6_3_2.setBounds(261, 161, 64, 64);
		 	getContentPane().add(btnPlayer6_3_2);
		 	btnPlayer6_3_2.addActionListener(new ActionListener() 
		 	{
		 		public void actionPerformed(ActionEvent e) 
		 		{
		 			
		 		}
		 	});
		 	
		 	//fin des joueurs
		 	
		 	JButton btnDeck = new JButton();
		 	btnDeck.setBounds(451, 296, 64, 64);
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
		 	
		 	JLabel lblJoueur1 = new JLabel("Joueur 1");
		 	lblJoueur1.setBounds(157, 411, 46, 14);
		 	getContentPane().add(lblJoueur1);
		 	
		 	JLabel lblJoueur2 = new JLabel("Joueur 2");
		 	lblJoueur2.setBounds(501, 411, 46, 14);
		 	getContentPane().add(lblJoueur2);
		 	
		 	JLabel lblJoueur3 = new JLabel("Joueur 3");
		 	lblJoueur3.setBounds(834, 411, 46, 14);
		 	getContentPane().add(lblJoueur3);
		 	
		 	JLabel lblJoueur4 = new JLabel("Joueur 4");
		 	lblJoueur4.setBounds(834, 236, 46, 14);
		 	getContentPane().add(lblJoueur4);
		 	
		 	JLabel lblJoueur5 = new JLabel("Joueur 5");
		 	lblJoueur5.setBounds(501, 236, 46, 14);
		 	getContentPane().add(lblJoueur5);
		 	
		 	JLabel lblJoueur6 = new JLabel("Joueur 6");
		 	lblJoueur6.setBounds(157, 236, 46, 14);
		 	getContentPane().add(lblJoueur6);

	 }
}
