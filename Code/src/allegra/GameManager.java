package allegra;
import java.util.List;

public class GameManager {
	
	/**
	 * remove card from chosen deck and return the card
	 * @param deckType
	 * @return the top card of the deck
	 */
	protected Card pickCard(int deckType){
		return null;
		
	}

	/**
	 * replace card in the player matrix at the coords and the new card is placed in the discard
	 * @param coord
	 * @param card
	 */
	protected void cardReplace(List<Integer> coord, Card card){

	}

	/**
	 * the card in param is sent to discard
	 * @param card
	 */
	protected void discardCard(Card card){

	}
	
	/**
	 * card2 from stealcoord is replaced with card1 from coord and vice versa
	 * old: card1 in coord and card2 in coord2
	 * new: card2 in coord and card1 in coord2
	 * @param coord
	 * @param player
	 * @param stealCoord
	 */
	protected void stealCard(List<Integer> coord,PlayerMatrix player, List<Integer> stealCoord){

	}

	/**
	 * iterate through all PlayerMatrix to check if all players have played last turn
	 * @return bool
	 */
	protected boolean checkEndGame(){
		return false;
	}

	
	/**
	 * init all Cards -> create shuffled Deck -> deal cards to PlayerMatrix, Discard
	 * @param players_number
	 */
	private void init(int players_number)
	{
		// for (int i = 0; i < players_number; i++)
		// {
		// 	final PlayerMatrix player = new PlayerMatrix();
		// 	this.listOfPlayers.add(player);
		// }
			
		// this.deck.fillDeck();
		// this.deck.shuffle();
			
		// //ADD THE PART WHERE PLAYERS RECEIVE CARD
			
		// this.discard.cards.clear();
		// this.discard.cards.add(this.deck.pickCard());
		// this.discard.cards.get(0).returnCard();
			
		// //ADD THE PART WHERE WE DETERMINE THE FIRST PLAYER

	}
}
