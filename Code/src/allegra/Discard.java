package allegra;

public class Discard extends Deck {
	/**
	 * @brief This method allows players to discard their card and add it on top of the discard pile
	 * @param c The card that the player discards
	 */
	public void discardCard(Card c)
	{
		this.cards.add(0, c);
	}
	
	/**
	 * @brief This method gives us the value of the top card in the discard pile
	 * @return The value of the top card
	 */
	public int showTopCard()
	{
		return this.cards.get(0).getValue();
	}
}
