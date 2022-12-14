package allegra;

import java.util.List;

public class Deck {
	protected List<Card> cards;
	
	public Card pickCard()
	{		
		if (this.cards.isEmpty()) return null;
		
		final Card pickedCard = this.cards.get(0);
		this.cards.remove(0);
		return pickedCard;
	}
}
