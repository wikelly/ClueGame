package clueGame;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.lang.reflect.Field;

public class ClueGame {
	private Board gameBoard = new Board();
	private Map<Character, String> rooms = new HashMap<Character, String>();
	private ArrayList<Card> deck = new ArrayList<Card>();
	private Map<String,ArrayList<Integer>> startingPositions = new HashMap<String, ArrayList<Integer>>();
	private Map<String, Color> players = new HashMap<String, Color>();
	private Solution solution;
	
	public ClueGame() throws BadConfigFormatException {
		loadRoomConfig("ClueLegend2.txt");
		loadConfigFiles("ClueLayout2.csv");
	}
	public ClueGame(String layout, String legend) throws BadConfigFormatException {
		loadRoomConfig(legend);
		loadConfigFiles(layout);
	}
	
	public ClueGame(String layout, String legend, String player, String deck) throws BadConfigFormatException {
		loadRoomConfig(legend);
		loadConfigFiles(layout);
		loadPlayerConfig(player);
		loadDeckConfig(deck);
	}
	
	private void loadDeckConfig(String deck) throws BadConfigFormatException{
		File f = new File(deck);
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String tmp;
			String[] tmp2;
			try {
				while ((tmp=br.readLine())!=null){
					tmp2 = new String[2];
					tmp2 = tmp.split(", ");
					if (tmp2.length != 2)
						throw new BadConfigFormatException();
					this.deck.add(new Card(tmp2[0], tmp2[1].charAt(0)));
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		deal();
		selectAnswer();
	}
	
	public void loadConfigFiles(String layout) throws BadConfigFormatException{
		gameBoard.loadBoardConfig(layout);
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
					if (tmp2.length != 2)
						throw new BadConfigFormatException();
					rooms.put(tmp2[0].charAt(0), tmp2[1]);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		gameBoard.setRooms(rooms);
	}
	
	public void loadPlayerConfig(String player) throws BadConfigFormatException{
		File f = new File(player);
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			String tmp;
			//String tmp1;
			String[] tmp2;
			ArrayList<Integer> startPos;
			
			try {
				while ((tmp=br.readLine())!=null){
					tmp2 = new String[2];
					startPos = new ArrayList<Integer>();
					tmp2 = tmp.split(", ");
					if (tmp2.length != 4)
						throw new BadConfigFormatException();
					players.put(tmp2[0],convertColor(tmp2[1]));
					startPos.add(Integer.parseInt(tmp2[2]));
					startPos.add(Integer.parseInt(tmp2[3]));
					startingPositions.put(tmp2[0], startPos);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		gameBoard.setPlayers(players);
		gameBoard.setStartingPositions(startingPositions);
		gameBoard.setGamePlayers();
	}
	
	public Color convertColor(String strColor) {
		Color color; 
		try {     
			// We can use reflection to convert the string to a color
			Field field = Class.forName("java.awt.Color").getField(strColor.trim());     
			color = (Color)field.get(null); } 
		catch (Exception e) {  
			color = null; // Not defined } 
		}
		return color;
	} 
	
	public void deal(){
		ArrayList<Card> dealDeck = new ArrayList<Card>(deck);
		Random rand = new Random();
		while(!dealDeck.isEmpty()){
			for(Player x: gameBoard.getGamePlayers()){
				if(dealDeck.isEmpty()){
					break;
				}
				int randInt =  rand.nextInt(dealDeck.size());
				x.getHand().add(dealDeck.get(randInt));
				dealDeck.remove(randInt);
			}
		}
	}
	
	public void selectAnswer(){
		String person = null;
		String room = null;
		String weapon = null;
		Random rand = new Random();
		int randCard = rand.nextInt(deck.size());
		while(person == null || room == null || weapon == null){
			if(deck.get(randCard).getCardType() == Card.CardType.PERSON){
				if(person == null){
					person = deck.get(randCard).getName();
				}
			}else if(deck.get(randCard).getCardType() == Card.CardType.ROOM){
				if(room == null){
					room = deck.get(randCard).getName();
				}
			}else if(deck.get(randCard).getCardType() == Card.CardType.WEAPON){
				if(weapon == null){
					weapon = deck.get(randCard).getName();
				}
			}
			
			randCard =  rand.nextInt(deck.size());
		}
		
		this.solution = new Solution(person, room, weapon);
	}
	
	
	public String makeSuggestion(String person, String room, String weapon, Player suggestingPlayer){
		
		return null;
	}
	
	public String handleSuggestion(String person, String room, String weapon, Player respondingPerson){
		ArrayList<String> possibleResponses = new ArrayList<String>();
		for(Card x: respondingPerson.getHand()){
			if(x.getName() == person || x.getName() == room || x.getName() == weapon){
				possibleResponses.add(x.getName());
			}
		}
		
		if(possibleResponses.isEmpty()){
			return null;
		}
		Random rand = new Random();
		int randResponse = rand.nextInt(possibleResponses.size());
		
		return possibleResponses.get(randResponse);
	}
	
	public boolean checkAccusation(Solution solution){
		if(solution.getPerson() == this.solution.getPerson()
				&& solution.getRoom() == this.solution.getRoom()
				&& solution.getWeapon() == this.solution.getWeapon()){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) throws BadConfigFormatException {
		ClueGame g = new ClueGame("ClueLayout.csv", "RoomLegend.txt", "Player.txt", "Deck.txt");
	}

	public Board getBoard() {
		return gameBoard;
	}
	public ArrayList<Card> getDeck(){
		return deck;
	}
	public Map<Character, String> getRooms() {
		return rooms;
	}
	
	public void setSolution(Solution solution){
		this.solution = solution;
	}
	
}
