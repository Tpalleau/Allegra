package allegra;

import java.util.ArrayList;
import java.util.List;

public class PlayerMatrix {

	private List<List<Card>> matrix = new ArrayList<>();
	private boolean lastTurn;

	//temporary method for DEBUG keep till end of project
	public void showMatrix(){
		System.out.println("matrix size:" + this.matrix.size());
		for (int i = 0; i < this.matrix.size(); i++) {
			System.out.println("	matrix subsize:" + this.matrix.get(i).size());
			System.out.print("    ");
			for (int j = 0; j < this.matrix.get(i).size(); j++) {
				if (matrix.get(i).get(j) == null){
					System.out.print("null ");
				}else{
					System.out.print(this.matrix.get(i).get(j).getValue() + " ");
				}
			}
			System.out.println("    ");
		}
	}

	public PlayerMatrix(List<Card> dealedCards){
		// add list of 3 cards for each column (5 columns)
		for (int i = 0; i < 5; i++) {
			this.matrix.add(
				new ArrayList<>(//list of cards
					dealedCards.subList(i*3, i*3+3)));//3 cards
		}
	}

	protected int flipCard(int x, int y){
		return matrix.get(x).get(y).flipCard();
	}
	
	protected Card replaceCard(int x, int y, Card card)
	{
		// returns value that was swapped
		return this.matrix.get(x).set(y, card);
	}
	
	protected int seeCard(int x, int y)
	{
		this.matrix.get(x).get(y).flipCard();
		return this.matrix.get(x).get(y).getValue();
	}
	
	/**
	 * check if 3 cards have identical value in 1 column
	 * @param x coord of the column to check
	 * @return bool 
	 */
	private boolean checkAllignedVertical(int x)
	{	
		// contains only 3 cards per column so if missing card then no allignment
		if (this.matrix.get(x).contains(null)) {
			return false;
		}

		// check if card is visible and same value
		int firstCard = this.matrix.get(x).get(0).getValue();
		for (Card card : this.matrix.get(x)) {
			if (!card.getVisible() || card.getValue() != firstCard){
				return false;
			}
		}

		return true;
	}
	
	/**
	 * check if 3 cards alligned
	 * @param y line to check
	 * @return 3 coords of x axis
	 */
	private List<Integer> checkAllignedHorizontal(int y)
	{
		// create list that will contain the index of the identical values of cards
		List<Integer> counterIndex = new ArrayList<>();

		// the card value to check with the other neighbor cards set to impossible value
		int checkCard = -2;
		for (int i = 0; i < this.matrix.size(); i++) {
			// if same value and visible
			if (matrix.get(i).get(y) == null) {
				//skip empty card
				;
			}else if (matrix.get(i).get(y).getVisible() && matrix.get(i).get(y).getValue() == checkCard) {
				// add index to the list
				counterIndex.add(i);

				// if 3 indexes (3 alligned cards)
				if (counterIndex.size() == 3) {
					//convert to int[] and return
					return counterIndex;
			}
			}else{
				// reset counterIndex
				counterIndex.clear();
				if (matrix.get(i).get(y).getVisible()){
					// reset with new card to compare
					checkCard = matrix.get(i).get(y).getValue();
					counterIndex.add(i);
				}else{
					// set to impossible value so checkCard gets reset next iteration
					checkCard = -2;
				}
			}
		}

		// if no cards where found return null
		return null;
	}
	
	/**
	 * remove alligned cards if any found, first vertical then horizontal (arbitrary choice)
	 *@param Card[] cards to be sent to discard
	 */
	protected List<Card> removeAligned()
	{
		// vertical removal
		for (int x = 0; x < 5; x++) {
			// returns bool
			if (this.checkAllignedVertical(x)){
				List<Card> cardsToDiscard = this.matrix.get(x);

				// remove cards from the matrix
				for (int y = 0; y < 3; y++) {
					matrix.get(x).set(y, null);
				}
				return cardsToDiscard;
			}
			// nothing found so check for next column
		}

		// if no verticial removal then do horizontal
		for (int y = 0; y < 3; y++) {
			// returns x coords of cards to remove
			List<Integer> coordCardsToDiscard = this.checkAllignedHorizontal(y);
			List<Card> cardsToDiscard = new ArrayList<>();

			// check if cards to discard are found
			if (coordCardsToDiscard != null) {
				for (int x : coordCardsToDiscard) {
					cardsToDiscard.add(matrix.get(x).get(y));

					// remove card from matrix
					this.matrix.get(x).set(y, null);
				}
				return cardsToDiscard;
			}
			// nothing found so check for next line
		}

		return null;
	}
	
	protected boolean checkAllVisible(){
		for (int x=0; x<3; x++)
			for (int y=0; y<4; y++)

				//check if coord is not empty then check if visible
				if (this.matrix.get(x).get(y) != null && !this.matrix.get(x).get(y).getVisible())
				{
					return false;
				}
		return true;
	}
}
