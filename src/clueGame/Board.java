package clueGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Board {
	private int numRows = 0, numColumns = 0;
	private Map<Character, String> rooms;
	private Set<BoardCell> targets;
	private Map<BoardCell, LinkedList<BoardCell>> adjMtx;
	private BoardCell[][] board;
	
	public void loadBoardConfig(String layout) throws BadConfigFormatException{
		try {
			numRows = 1;
			Scanner fin = new Scanner(new File(layout));
			numColumns = fin.nextLine().split(",").length;
			while (fin.hasNextLine()){
				if (fin.nextLine().split(",").length != numColumns)
					throw new BadConfigFormatException();
				numRows++;
				
			}
			
			board = new BoardCell[numRows][numColumns];
			fin = new Scanner(new File(layout));
			int i = 0;
			String ar[];
			while (fin.hasNextLine()){
				ar = fin.nextLine().split(",");
				for (int j = 0; j < ar.length; j++){
					if(!rooms.containsKey(ar[j].charAt(0)))
						throw new BadConfigFormatException();
					if (ar[j].equals("W")){
						board[i][j] = new Walkway();
					}else {
						board[i][j] = new RoomCell(ar[j]);
					}
				}
			}
			fin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void calcTargets(){
		
	}
	public int getNumRows() {
		return numRows;
	}
	public int getNumColumns() {
		return numColumns;
	}
	public void calcAdjacencies(){
		
	}
	public void getTargets(){
		
	}
	public LinkedList<BoardCell> getAdjList(int column, int row){
		return null;
		
	}
	public BoardCell getCellAt(int column, int row){
		return null;
		
	}
	public Map<Character, String> getRooms() {
		return rooms;
	}
	public RoomCell getRoomCellAt(int a, int b){
		return null;
		
	}
	public void setRooms(Map<Character, String> rooms) {
		this.rooms = rooms;
	}
	
}
