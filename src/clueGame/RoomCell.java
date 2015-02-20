package clueGame;

public class RoomCell extends BoardCell{;
	static public DoorDirection DoorDirection;
	private char roomInitial;
	
	
	public RoomCell(String room) {
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
			else {
				DoorDirection = DoorDirection.NONE;
			}
		}
		else {
			DoorDirection = DoorDirection.NONE;
		}
		
	}
	
	@Override
	public boolean isRoom() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isDoorway() {
		if (DoorDirection == DoorDirection.NONE){
			return false;
		}else {
			return true;
		}
	}



	public DoorDirection getDoorDirection() {
		return DoorDirection;
	}
	public char getInitial() {
		return roomInitial;
	}
}
