package clueGame;

import java.util.Map;

public class ClueGame {
	private Board b = new Board();
	private Map<Character, String> rooms;
	
	public void loadConfigFiles(){
		b.loadBoardConfig(rooms);
	}
	public void loadRoomConfig(){
		
	}
}
