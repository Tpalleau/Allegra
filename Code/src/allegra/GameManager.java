package allegra;
import java.util.List;

public class GameManager {
	protected List<PlayerMatrix> listOfPlayers;
	protected Deck deck, discard;
	
	protected Card pickingCard(Deck d)
	{
		return d.pickCard();
	}
	
	protected void discardCard(Card c)
	{
		this.discard.cards.add(c);
	}
	
	
	
	private void start(int players_number)
	{
		for (int i = 0; i < players_number; i++)
		{
			final PlayerMatrix player = new PlayerMatrix();
			this.listOfPlayers.add(player);
		}
			
		this.deck.fillDeck();
		this.deck.shuffle();
			
		//ADD THE PART WHERE PLAYERS RECEIVE CARD
			
		this.discard.cards.clear();
		this.discard.cards.add(this.deck.pickCard());
		this.discard.cards.get(0).returnCard();
			
		//ADD THE PART WHERE WE DETERMINE THE FIRST PLAYER

		
		
	}
}
