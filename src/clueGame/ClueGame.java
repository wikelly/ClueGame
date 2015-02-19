package clueGame;

import java.util.Map;

public class ClueGame {
	private Board b = new Board();
	private Map<Character, String> rooms;
	
	public ClueGame(String layout, String legend) {
		
	}
	
	public void loadConfigFiles(){
		b.loadBoardConfig();
	}
	
	public void loadRoomConfig(){
		
	}

	public Board getBoard() {
		return b;
	}

	public Map<Character, String> getRooms() {
		return rooms;
	}
	
}
