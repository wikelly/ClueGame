package clueGame;

public class BoardCell {
	private int row, column;
	private DoorDirection dd;
	public boolean isWalkway(){
		return false;	
	}
	public boolean isRoom(){
		return false;
	}
	public boolean isDoorway(){
		return false;
	}
}
