package allegra;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
	private List<PlayerMatrix> listPlayers = new ArrayList<>();
	private DrawPile drawPile = new DrawPile();
	private DiscardPile discardPile = new DiscardPile();
	private PlayerMatrix playerPlaying;
	private int indexPlayerPlaying = 0;



	/**
	 * deal cards to PlayerMatrix, Discard
	 * @param num_players
	 */
	public GameManager(int numPlayers)
	{
		List<Card> dealtCards = drawPile.dealCards(numPlayers);

		//deal card to Discard
		this.discardPile.discardCard(dealtCards.remove(0));

		for (int player = 0; player < numPlayers; player++) {
			// last player has list composed of last 12 + first 3 cards (shared columns)
			if (player == numPlayers-1){

				List<Card> matrixList = dealtCards.subList(player*12, player*12+12);
				matrixList.addAll(dealtCards.subList(0, 3));
				this.listPlayers.add(new PlayerMatrix(matrixList));
			}
			else{
				this.listPlayers.add(new PlayerMatrix(dealtCards.subList(player*12, player*12+15)));
			}
		}
		
		this.playerPlaying = this.listPlayers.get(indexPlayerPlaying);
	}

	// TEMP method for debug
	public void showAllMatrix(){
		this.listPlayers.forEach(PlayerMatrix::showMatrix);
	}
	public void showMatrix(){
		playerPlaying.showMatrix();
	}

	/**
	 * changes internal playerPlaying to the next player who has not played last turn
	 * @return index of next player
	 */
	public int nextPlayer(){
		do {
			indexPlayerPlaying = (indexPlayerPlaying+1)%listPlayers.size();
			playerPlaying = listPlayers.get(indexPlayerPlaying);
		} while (playerPlaying.lastTurnPLayed);
		return indexPlayerPlaying;
	}

	public int FlipCard(int x, int y){
		return playerPlaying.flipCard(x, y);
	}

	public int getNeighbor(){
		return (indexPlayerPlaying+1)%listPlayers.size();
	}
	
	/**
	 * remove card from chosen drawPile and return the card
	 * @param deckType
	 * @return the top card of the deck
	 */
	public Card pickCard(int deckType) {
		// returns card that is sent to discard
		return switch (deckType) {
			case 0 -> drawPile.pickCard();
			case 1 -> discardPile.pickCard();
			default -> null;
		};
	}

	/**
	 * replace card in the player matrix at the coords and return value of card sent to discard
	 * @param x & y
	 * @param card
	 */
	public int replaceCard(int x, int y, Card card){
		Card removedCard = playerPlaying.replaceCard(x, y, card);
		discardCard(removedCard);
		return removedCard.getValue();
}

	/**
	 * the card in param is sent to discard
	 * @param card
	 */
	public void discardCard(Card card){discardPile.discardCard(card);}

	public int showTopDiscardPile(){return discardPile.showTopCard();}

	/**
	 * card2 from stealcoord is replaced with card1 from coord and vice versa
	 * old: card1 in coord and card2 in coord2
	 * new: card2 in coord and card1 in coord2
	 * @param coord
	 * @param player
	 * @param stealCoord
	 */
	public void stealCard(int[] coord,PlayerMatrix player, int[] stealCoord){
		Card cardHolder = player.replaceCard(stealCoord[0], stealCoord[1], null);
		cardHolder = playerPlaying.replaceCard(coord[0], coord[1], cardHolder);
		player.replaceCard(stealCoord[0], stealCoord[1], cardHolder);
	}

	public boolean checkLastTurn(){
		return playerPlaying.lastTurnPLayed;

	}

	/**
	 * iterate through all PlayerMatrix to check if all players have played last turn
	 * @return bool
	 */
	public boolean checkEndGame(){
		for (PlayerMatrix player : listPlayers) {
			if (!player.lastTurnPLayed) {
				return false;
			}
		}
		return true;
	}
}
