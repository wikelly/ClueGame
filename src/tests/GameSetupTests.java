package tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.BadConfigFormatException;
import clueGame.Board;
import clueGame.BoardCell;
import clueGame.ClueGame;
import clueGame.ComputerPlayer;
import clueGame.HumanPlayer;
import clueGame.Player;
import clueGame.Card;

public class GameSetupTests {

	private static Board board;
	private static ClueGame game;
	public static final int NUM_ROOMS = 11;
	public static final int NUM_ROWS = 22;
	public static final int NUM_COLUMNS = 23;
	public static final int NUM_PLAYERS = 6;
	public static final int NUM_CARDS = 21;
	
	
	@BeforeClass
	public static void setUp() throws BadConfigFormatException {
		game = new ClueGame("ClueLayout.csv", "RoomLegend.txt", "Players.txt", "Deck.txt");
		//game.loadConfigFiles("ClueLayout.csv");
		board = game.getBoard();
		//Map<String, String> players = board.getPlayers();
		
	}
	
	//The Following are PLAYER LOADING TESTS ---------
	//
	//Test that the players are loaded
	@Test
	public void testPlayers() {
		Map<String, Color> players = board.getPlayers();
		
		assertTrue(players.containsKey("Colonel Mustard"));
		assertTrue(players.containsKey("Professor Plum"));
		assertTrue(players.containsKey("Miss Scarlet"));
		assertTrue(players.containsKey("Mrs. White"));
		assertTrue(players.containsKey("Reverend Green"));
		assertTrue(players.containsKey("Mrs. Peacock"));
	}
	@Test
	public void testPlayerNumber(){
		ArrayList<Player> gamePlayers = board.getGamePlayers();
		assertEquals(gamePlayers.size(), NUM_PLAYERS);
	}
	//Tests the Player Initial Location
	@Test
	public void testPlayerLocation(){
		//board.setGamePlayers();
		ArrayList<Player> gamePlayers = board.getGamePlayers();
		for(Player x: gamePlayers){
			switch(x.getName()){
			case "Colonel Mustard":
				assertEquals(x.getLocation(), board.getBoardCellAt(4,0));
				break;
			case "Professor Plum":
				assertEquals(x.getLocation(), board.getBoardCellAt(12,0));
				break;
			case "Miss Scarlet":
				assertEquals(x.getLocation(), board.getBoardCellAt(0,14));
				break;
			case "Mrs. Peacock":
				assertEquals(x.getLocation(), board.getBoardCellAt(17,22));
				break;
			case "Mrs. White":
				assertEquals(x.getLocation(), board.getBoardCellAt(0,19));
				break;
			case "Reverend Green":
				assertEquals(x.getLocation(), board.getBoardCellAt(10,22));
				break;
				
			}
		}
		
	}
	
	//Tests the players proper colors
	@Test
	public void testPlayerColors() {
		Map<String, Color> players = board.getPlayers();
		assertEquals(Color.YELLOW, players.get("Colonel Mustard"));
		assertEquals(Color.MAGENTA, players.get("Professor Plum"));
		assertEquals(Color.RED, players.get("Miss Scarlet"));
		assertEquals(Color.WHITE, players.get("Mrs. White"));
		assertEquals(Color.GREEN, players.get("Reverend Green"));
		assertEquals(Color.BLUE, players.get("Mrs. Peacock"));
	}
	
	//The following are DECK LOADING AND DEALING TESTS---------------------------
	//
	//Test loading the deck
	@Test
	public void testDeckSize(){
		ArrayList<Card> testDeck = game.getDeck();
		assertEquals(testDeck.size(), NUM_CARDS);
		
	}

	//Test the Deal
	@Test
	public void testDeal(){
		int cardsDealt = 0;
		for(Player x: board.getGamePlayers()){
			assertTrue(x.getHand().size() < 5 && x.getHand().size() > 2);
			cardsDealt += x.getHand().size();
		}
		
		assertEquals(cardsDealt, NUM_CARDS);
	
	}
	
	//This test ensures that no card is dealt twice
	@Test
	public void testUniqueCards(){
		Set<Card> dealtCards = new HashSet<Card>();
		for(Player x: board.getGamePlayers()){
			for(Card y: x.getHand()){
				if(dealtCards.contains(y)){
					fail("card already dealt");
				}else{
					dealtCards.add(y);
				}
			}
		}
		
		assertEquals(dealtCards.size(), NUM_CARDS);
	}
}
