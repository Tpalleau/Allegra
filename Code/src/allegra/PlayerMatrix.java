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
			for (int j = 0; j < this.matrix.get(i).size(); j++) {
				System.out.print(this.matrix.get(i).get(j).getValue() + " ");
			}
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
	
	protected Card replaceCard(int x, int y, Card c)
	{
		final Card discCard = this.matrix.get(x).get(y);
		this.matrix.get(x).set(y, c);
		return discCard;
	}
	
	protected int seeCard(int x, int y)
	{
		this.matrix.get(x).get(y).flipCard();
		return this.matrix.get(x).get(y).getValue();
	}
	
	//Since there are only three cards vertically, we don't need to know precisely which card we flipped,
	//The column is enough
	private int[] checkAllignedVertical(int y)
	{		
		//On two separate lines to read this more easily
		// if (this.matrix.get(0).get(y).getValue() == this.matrix.get(1).get(y).getValue())
		// 	if (this.matrix.get(2).get(y).getValue() == this.matrix.get(1).get(y).getValue())
		// 	{
		// 		arr[1] = arr[3] = arr[5] = y;
		// 		arr[0] = 0;
		// 		arr[2] = 1;
		// 		arr[4] = 2;
		// 		return arr;
		// 	}
		
		// arr[0] = -1;
		// return arr;
		return null;
	}
	
	//CAN MAYBE BE OPTIMISED
	//-> TO REWORK BECAUSE IT DOESN'T TAKE INTO ACCOUNT THE SHARED COLUMNS
	private int[] checkAllignedHorizontal(int x, int y)
	{
		final int[] arr = new int[6];
		
		if (x==0)
		{
			if (this.matrix.get(0).get(y).getValue() == this.matrix.get(1).get(y).getValue())
				if (this.matrix.get(2).get(y).getValue() == this.matrix.get(1).get(y).getValue())
				{
					arr[1] = arr[3] = arr[5] = y;
					arr[0] = 0;
					arr[2] = 1;
					arr[4] = 2;
					return arr;
				}
		}
			
		else
			if (this.matrix.get(0).get(y).getValue() == this.matrix.get(1).get(y).getValue())
				if (this.matrix.get(2).get(y).getValue() == this.matrix.get(1).get(y).getValue())
				{
					arr[1] = arr[3] = arr[5] = y;
					arr[0] = 1;
					arr[2] = 2;
					arr[4] = 3;
					return arr;
				}
		arr[0] = -1;
		return arr;
	}
	
	//TO UPDATE ACCORDING TO HOW THE GAME REACTS TO REMOVED CARDS
	protected void removeAligned(int[] coords)
	{
		if (coords[0] != -1)
			for (int i=0; i<3; i++) this.matrix.get(coords[2*i]).set(coords[2*i + 1], null);
	}
	
	protected boolean checkAllVisible()
	{
		for (int x=0; x<3; x++)
			for (int y=0; y<4; y++)
				if (this.matrix.get(x).get(y).getVisible())
				{
					return false;
				}
		return true;
	}
}
