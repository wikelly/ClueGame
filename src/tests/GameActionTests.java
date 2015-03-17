package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import clueGame.BadConfigFormatException;
import clueGame.Board;
import clueGame.ClueGame;
import clueGame.Solution;

public class GameActionTests {
	
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
		board = game.getBoard();
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
	

}
