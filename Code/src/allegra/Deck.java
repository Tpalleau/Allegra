package allegra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	protected List<Card> cards = new ArrayList<Card>();
	
	public Card pickCard()
	{		
		if (this.cards.isEmpty()) return null;
		
		//We add at the end of the list (we "read it backwards")
		final Card pickedCard = this.cards.get(this.cards.size()-1);
		this.cards.remove(this.cards.size()-1);
		return pickedCard;
	}
	
	private void fillDeck()
	{
		for (int i=0; i<8; i++)
			for (int j=-1; j<4; j++)
				cards.add(new Card(j));
		
		for (int i=0; i<11; i++)
			for (int j=4; j<8; j++)
				cards.add(new Card(j));
		
		for (int i=0; i<8; i++)
			for (int j=8; j<12; j++)
				cards.add(new Card(j));
		
	}

	public Deck(){
		fillDeck();
		Collections.shuffle(this.cards);
		System.out.println(cards.size());
	}
}
