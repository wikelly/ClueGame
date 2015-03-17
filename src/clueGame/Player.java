package clueGame;

import java.awt.Color;
import java.util.ArrayList;

public class Player {
	private String name;
	private Color color;
	private ArrayList<Card> hand = new ArrayList<Card>();
	private BoardCell location;
	
	public Player(String name, Color color, BoardCell location){
		this.name =  name;
		this.color = color;
		this.location = location;
	}
	
	public Card disproveSuggestion(String person, String room, String weapon){
		
		return new Card();
	}
	
	//Set location method for initial board setup
	public void setLocation(BoardCell currentLocation){
		location = currentLocation;
		
	}
	public BoardCell getLocation(){
		return location;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setColor(Color color){
		this.color = color;
	}
	public ArrayList<Card> getHand(){
		return hand;
	}
}
