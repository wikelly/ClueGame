package clueGame;

public class RoomCell extends BoardCell{;
	static public DoorDirection DoorDirection;
	private char roomInitial;
	
	
	public RoomCell(String room) throws BadConfigFormatException {
		super();
		
		roomInitial = room.charAt(0);
		if (room.length() == 2){
			if(room.charAt(1) == 'R'){
				super.dd = DoorDirection.RIGHT;
			}
			else if(room.charAt(1) == 'L'){
				super.dd = DoorDirection.LEFT;
			}
			else if(room.charAt(1) == 'U'){
				super.dd = DoorDirection.UP;
			}
			else if(room.charAt(1) == 'D'){
				super.dd = DoorDirection.DOWN;
			}
			else if(room.charAt(1) == 'N'){
				super.dd = DoorDirection.NONE;
			}
			else {
				throw new BadConfigFormatException();
			}
		}
		else {
			super.dd = DoorDirection.NONE;
		}
		
	}
	
	


	@Override
	public boolean isRoom() {
		// TODO Auto-generated method stub
		return super.isRoom();
	}




	@Override
	public boolean isDoorway() {
		if (super.dd == DoorDirection.NONE){
			return false;
		}else {
			return true;
		}
	}




	public DoorDirection getDoorDirection() {
		return super.dd;
	}
	public char getInitial() {
		return roomInitial;
	}
}
