package allegra;

import java.util.List;

public class PlayerMatrix {
	
	//MAY NEED SOME REWORK TO MAKE SURE IT'S IN THE RIGHT "DIRECTION"
	//(A list composed of five lists of three elements,
	//instead of a list composed of three lists of five elements)
	//(This is to make sure we can have the shared column work correctly)
	protected List<List<Card>> matrix;
	protected boolean lastTurn;
	
	protected Card replaceCard(int x, int y, Card c)
	{
		final Card temp = this.matrix.get(x).get(y);
		this.matrix.get(x).set(y, c);
		return temp;
	}
	
	protected int seeCard(int x, int y)
	{
		return this.matrix.get(x).get(y).getValue();
	}
	
	//Since there are only three cards vertically, we don't need to know precisely which card we flipped,
	//The column is enough
	private int[] checkAllignedVertical(int y)
	{
		final int[] arr = new int[6];
		
		//On two separate lines to read this more easily
		if (this.matrix.get(0).get(y).getValue() == this.matrix.get(1).get(y).getValue())
			if (this.matrix.get(2).get(y).getValue() == this.matrix.get(1).get(y).getValue())
			{
				arr[1] = arr[3] = arr[5] = y;
				arr[0] = 0;
				arr[2] = 1;
				arr[4] = 2;
				return arr;
			}
		
		arr[0] = -1;
		return arr;
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
