package clueGame;

public class RoomCell extends BoardCell{;
	static public DoorDirection DoorDirection;
	private char roomInitial;
	
	
	public RoomCell(String room) throws BadConfigFormatException {
		super();
		
		roomInitial = room.charAt(0);
		if (room.length() == 2){
			if(room.charAt(1) == 'R'){
				DoorDirection = DoorDirection.RIGHT;
			}
			else if(room.charAt(1) == 'L'){
				DoorDirection = DoorDirection.LEFT;
			}
			else if(room.charAt(1) == 'U'){
				DoorDirection = DoorDirection.UP;
			}
			else if(room.charAt(1) == 'D'){
				DoorDirection = DoorDirection.DOWN;
			}
			else if(room.charAt(1) == 'N'){
				DoorDirection = DoorDirection.NONE;
			}
			else {
				throw new BadConfigFormatException();
			}
		}
		else {
			DoorDirection = DoorDirection.NONE;
		}
		
	}
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
