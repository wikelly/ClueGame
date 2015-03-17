package tests;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.BadConfigFormatException;
import clueGame.Board;
import clueGame.BoardCell;
import clueGame.Card;
import clueGame.ClueGame;
import clueGame.ComputerPlayer;
import clueGame.HumanPlayer;
import clueGame.Player;
import clueGame.Solution;

public class GameActionTests {
	
	private static Board board;
	private static ClueGame game;
	public static final int NUM_ROOMS = 11;
	public static final int NUM_ROWS = 22;
	public static final int NUM_COLUMNS = 23;
	public static final int NUM_PLAYERS = 6;
	public static final int NUM_CARDS = 21;
	
	private static Card mustardCard;
	private static Card greenCard;
	private static Card hallCard;
	private static Card conservatoryCard;
	private static Card wrenchCard;
	private static Card knifeCard;
	
	
	@BeforeClass
	public static void setUp() throws BadConfigFormatException {
		game = new ClueGame("ClueLayout.csv", "RoomLegend.txt", "Players.txt", "Deck.txt");
		board = game.getBoard();
		
		mustardCard = new Card("Colonel Mustard", Card.CardType.PERSON);
		greenCard = new Card("Reverend Green", Card.CardType.PERSON);
		hallCard = new Card("Hall", Card.CardType.ROOM);
		conservatoryCard = new Card("Conservatory", Card.CardType.ROOM);
		wrenchCard = new Card("Wrench", Card.CardType.WEAPON);
		knifeCard = new Card("Knife", Card.CardType.WEAPON);
	}
	
	
	//The following are ACCUSATION TESTS --------------------
	//
	
	@Test
	public void testAccusations() {
		game.setSolution(new Solution("Colonel Mustard", "Conservatory", "Knife"));
		
		//Correct Accusations
		Solution testAccurateSolution = new Solution("Colonel Mustard", "Conservatory", "Knife");
		assertTrue(game.checkAccusation(testAccurateSolution));
		
		//Incorrect Person
		Solution testInaccuratePerson = new Solution("Reverend Green", "Conservatory", "Knife");
		assertFalse(game.checkAccusation(testInaccuratePerson));
		
		//Incorrect Room
		Solution testInaccurateRoom = new Solution("Colonel Mustard", "Kitchen", "Knife");
		assertFalse(game.checkAccusation(testInaccurateRoom));
		
		//Inaccurate Weapon
		Solution testInaccurateWeapon = new Solution("Colonel Mustard", "Conservatory", "Wrench");
		assertFalse(game.checkAccusation(testInaccurateWeapon));
		
		//All three wrong
		Solution testInaccurateAll = new Solution("Reverend Green", "Kitchen", "Wrench");
		assertFalse(game.checkAccusation(testInaccurateAll));
	}
	
	//The following are SUGGESTION TESTS -------------------------------
	//
	
	//These tests are for the suggestion checking function
	@Test
	public void disproveSuggestionTests(){
		Player testPlayer = new Player("Colonel Mustard", Color.YELLOW, new BoardCell());
		testPlayer.getHand().add(mustardCard);
		testPlayer.getHand().add(greenCard);
		testPlayer.getHand().add(hallCard);
		testPlayer.getHand().add(conservatoryCard);
		testPlayer.getHand().add(knifeCard);
		testPlayer.getHand().add(wrenchCard);
		
		//Tests the correct person is returned
		assertEquals("Colonel Mustard", game.handleSuggestion("Colonel Mustard", "Billiard Room", "Pipe", testPlayer));
		assertEquals("Reverend Green", game.handleSuggestion("Reverend Green", "Billiard Room", "Pipe", testPlayer));
		
		//Tests that the correct room is returned
		assertEquals("Hall", game.handleSuggestion("Miss Scarlet", "Hall", "Pipe", testPlayer));
		assertEquals("Conservatory", game.handleSuggestion("Miss Scarlet", "Hall", "Pipe", testPlayer));

		//Tests that the correct weapon is returned
		assertEquals("Knife", game.handleSuggestion("Miss Scarlet", "Billiard Room", "Knife", testPlayer));
		assertEquals("Wrench", game.handleSuggestion("Miss Scarlet", "Billiard Room", "Knife", testPlayer));

		//Tests that nothing is returned if the player has none of the cards
		assertEquals(null, game.handleSuggestion("Miss Scarlet", "Billiard Room", "Pipe", testPlayer));

		//Tests that the player will randomly return one valid card if asked for several
		int roomCount = 0;
		int weaponCount = 0;
		int personCount = 0;
		String result;
		
		for(int i=0;i<20;i++){
			result = game.handleSuggestion("Colonel Mustard", "Conservatory", "Knife", testPlayer);
			switch(result){
			case "Colonel Mustard":
				personCount++;
				break;
			case "Conservatory":
				roomCount++;
				break;
			case "Knife":
				weaponCount++;
				break;
			default:
					fail("wrong card returned!");
					break;
					
			}
			
			
		}
		
		assertTrue(roomCount > 0);
		assertTrue(weaponCount >0);
		assertTrue(personCount > 0);
	}
	
	@Test
	public void testAllPlayersQueried(){
		ArrayList<Player> testPlayers = new ArrayList<Player>();
		Player testPlayer1 = new HumanPlayer("test", Color.GREEN, new BoardCell());
		Player testPlayer2 = new ComputerPlayer("test", Color.GREEN, new BoardCell());
		Player testPlayer3 = new ComputerPlayer("test", Color.GREEN, new BoardCell());
		Player testPlayer4 = new ComputerPlayer("test", Color.GREEN, new BoardCell());
		
		testPlayer1.getHand().add(mustardCard);
		testPlayer2.getHand().add(greenCard);
		testPlayer3.getHand().add(knifeCard);
		testPlayer4.getHand().add(conservatoryCard);

		
	}

}
