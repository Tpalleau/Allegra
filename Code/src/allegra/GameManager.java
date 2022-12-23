package allegra;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
	protected List<PlayerMatrix> listPlayers = new ArrayList<>();
	protected Deck deck = new Deck();
	protected PlayerMatrix playerPlaying;

	/**
	 * init all Cards -> create shuffled Deck -> deal cards to PlayerMatrix, Discard
	 * @param num_players
	 */
	public void init(int numPlayers)
	{
		for (int player = 0; player < numPlayers; player++) {

			this.listPlayers.add(new PlayerMatrix(deck.dealCards()));
		}
	
		this.playerPlaying = this.listPlayers.get(0);

	}

	
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
}
