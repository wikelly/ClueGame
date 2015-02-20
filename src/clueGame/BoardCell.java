package clueGame;

public class BoardCell {
	private int row, column;
	protected DoorDirection dd;
	
	public boolean isWalkway(){
		return false;	
	}
	public boolean isRoom(){
		return false;
	}
	public boolean isDoorway(){
		return false;
	}
	// Add method draw when making GUI
}
