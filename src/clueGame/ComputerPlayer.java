package clueGame;

import java.awt.Color;
import java.util.Set;

public class ComputerPlayer extends Player {
	private char lastRoomVisited;
	
	public ComputerPlayer(String name, Color color, BoardCell location){
		super(name, color, location);
	}
	
	public void pickLocation(Set<BoardCell> targets){
		
	}
	
	public void createSuggestion(){
		
	}
	
	public void updateSeen(Card seen){
		
	}
}
