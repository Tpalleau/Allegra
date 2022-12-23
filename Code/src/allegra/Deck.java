package allegra;

import java.util.List;
import java.util.Random;

public class Deck {
	protected List<Card> cards;
	
	public Card pickCard()
	{		
		if (this.cards.isEmpty()) return null;
		
		//We add at the end of the list (we "read it backwards")
		final Card pickedCard = this.cards.get(this.cards.size()-1);
		this.cards.remove(this.cards.size()-1);
		return pickedCard;
	}
	
	//FIX THE ISSUE WITH NULL AND INITIALISATION
	public void shuffle()
	{
		final List<Card> new_deck = null;
		final Random rand = new Random();
		while (!this.cards.isEmpty())
		{
			final int rand_num = rand.nextInt(this.cards.size());
			new_deck.add(this.cards.get(rand_num));
			this.cards.remove(rand_num);
		}
		this.cards.addAll(new_deck);
	}
	
	public void fillDeck()
	{
		final List<Card> temp = null;
		for (int i=0; i<8; i++)
			for (int j=-1; j<4; j++)
				temp.add(new Card(j));
		
		for (int i=0; i<11; i++)
			for (int j=4; j<8; j++)
				temp.add(new Card(j));
		
		for (int i=0; i<8; i++)
			for (int j=8; j<12; j++)
				temp.add(new Card(j));
		
		this.cards.clear();
		this.cards.addAll(temp);
	}
}
