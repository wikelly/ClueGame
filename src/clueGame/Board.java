package clueGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Board {
	private int numRows, numColumns;
	private Map<Character, String> rooms;
	private Set<BoardCell> targets;
	private Map<BoardCell, LinkedList<BoardCell>> adjMtx;
	private BoardCell[][] board;
	
	public void loadBoardConfig(){
		try {
			Scanner fin = new Scanner(new File("ClueLayout.csv"));
			int i = 0;
			String ar[];
			while (fin.hasNextLine()){
				ar = fin.nextLine().split(",");
				for (int j = 0; j < ar.length; j++){
					if (ar[j].equals("W")){
						board[i][j] = new BoardCell();
					}
				}
			}
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
}
