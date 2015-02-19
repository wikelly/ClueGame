package clueGame;

public class RoomCell extends BoardCell{;
	private DoorDirection doorDirection;
	private char room;
		
	public boolean isRoom(){
		return true;
	}
	// Override draw method later in GUI
}
