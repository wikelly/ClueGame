package clueGame;

public class RoomCell extends BoardCell{;
	private DoorDirection doorDirection;
	private char roomInitial;
		
	public boolean isRoom(){
		return true;
	}
	// Override draw method later in GUI

	public DoorDirection getDoorDirection() {
		return doorDirection;
	}
	public char getInitial() {
		return roomInitial;
	}
}
