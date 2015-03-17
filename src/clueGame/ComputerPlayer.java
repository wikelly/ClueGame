package clueGame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ComputerPlayer extends Player {
	private char lastRoomVisited;
	
	public ComputerPlayer(String name, Color color, BoardCell location){
		super(name, color, location);
	}
	
	public BoardCell pickLocation(Set<BoardCell> targets){
		//copies the set to a new Set we can delete/manipulate
	
		ArrayList<BoardCell> roomTargets = new ArrayList<BoardCell>();
		ArrayList<BoardCell> otherTargets = new ArrayList<BoardCell>();
		
		for(BoardCell x: targets){
			if(x.isRoom()){
				if(((RoomCell)x).getRoomInitial() == lastRoomVisited){
					otherTargets.add(x);
				}else{
					roomTargets.add(x);
				}
			}else{
				otherTargets.add(x);
			}
		}
		Random rand = new Random();
		int randTarget;
		if(!roomTargets.isEmpty()){
			randTarget = rand.nextInt(roomTargets.size());
			return roomTargets.get(randTarget);
		}
		
		randTarget = rand.nextInt(otherTargets.size());
		return otherTargets.get(randTarget);
	}
	
	public void createSuggestion(){
		
	}
	
	public void setLastRoomVisited(char lastRoomVisited){
		this.lastRoomVisited = lastRoomVisited;
	}
	
	public void updateSeen(Card seen){
		
	}
}
