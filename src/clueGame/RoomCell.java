package clueGame;

public class RoomCell extends BoardCell{;
	static public DoorDirection DoorDirection;
	private char roomInitial;
		
	public boolean isRoom(){
		return true;
	}
	// Override draw method later in GUI

	public DoorDirection getDoorDirection() {
		return DoorDirection;
	}
	public char getInitial() {
		return roomInitial;
	}
}
