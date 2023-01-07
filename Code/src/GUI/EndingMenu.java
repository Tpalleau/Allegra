package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.Box;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;



public class EndingMenu extends JFrame {
	
	public EndingMenu(HashMap<Integer, Integer> playerMap) {
		
	    
		int nbPlayers = playerMap.size();
		// set default screen settings
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(50+150*nbPlayers,140);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		playerMap = sortHashMap(playerMap);

		for (Integer i : playerMap.keySet()) {
			
			
			JLabel playerName = new JLabel("joueur " +(i + 1));
			playerName.setBounds(50 + 150*i, 20, 70, 20);
			getContentPane().add(playerName);
			
			JLabel playerPoints = new JLabel(playerMap.get(i) + " points");
			playerPoints.setBounds(50 + 150*i, 60, 70, 20);
			getContentPane().add(playerPoints);
			
			if(i == 0) {
				JLabel results = new JLabel("1er");
				results.setBounds(16+150*i, 11, 70, 20);
				getContentPane().add(results);
			}else {
				JLabel results = new JLabel(i + 1 +"eme");
				results.setBounds(16+150*i, 11, 70, 20);
				getContentPane().add(results);
			}
			
		}
		
	}

	private HashMap<Integer, Integer> sortHashMap(HashMap<Integer, Integer> hashmap){
		
		
		List<Integer> sortedValues = new ArrayList<>();
		
		int size = hashmap.size();
		
		for (Integer i : hashmap.values()) { //put the values in a list and sort it
		      sortedValues.add(i);
		}
		Collections.sort(sortedValues);
		hashmap.clear();
		
		for (int i = 0; i<size; i++) { //put the values in a list and sort it
		      hashmap.put(i, sortedValues.get(i));
		}
		
		return hashmap;
	}
	
}
