package clueGame;

import java.awt.Color;
import java.util.Set;

public class ComputerPlayer extends Player {
	private char lastRoomVisited;
	
	public ComputerPlayer(String name, Color color, BoardCell location){
		super(name, color, location);
	}
	
	public BoardCell pickLocation(Set<BoardCell> targets){
		return new BoardCell();
	}
	
	public void createSuggestion(){
		
	}
	
	public void setLastRoomVisited(char lastRoomVisited){
		this.lastRoomVisited = lastRoomVisited;
	}
	
	public void updateSeen(Card seen){
		
	}
}
