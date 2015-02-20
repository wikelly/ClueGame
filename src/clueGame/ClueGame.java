package clueGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ClueGame {
	private Board b = new Board();
	private Map<Character, String> rooms = new HashMap<Character, String>();
	
	public ClueGame(String layout, String legend) throws BadConfigFormatException {
		loadRoomConfig(legend);
		loadConfigFiles(layout);
	}
	
	public void loadConfigFiles(String layout) throws BadConfigFormatException{
		b.loadBoardConfig(layout);
	}
	
	public void loadRoomConfig(String legend) throws BadConfigFormatException{
		File f = new File(legend);
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String tmp;
			String[] tmp2;
			try {
				while ((tmp=br.readLine())!=null){
					tmp2 = new String[2];
					tmp2 = tmp.split(", ");
					rooms.put(tmp2[0].charAt(0), tmp2[1]);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		b.setRooms(rooms);
	}
	
	public static void main(String[] args) throws BadConfigFormatException {
		ClueGame g = new ClueGame("ClueLayout.csv", "RoomLegend.txt");
	}

	public Board getBoard() {
		return b;
	}

	public Map<Character, String> getRooms() {
		return rooms;
	}
	
}
