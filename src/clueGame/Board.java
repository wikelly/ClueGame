package clueGame;

import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Board {
	private int numRows, numColumns;
	private Map<Character, String> rooms;
	private Set<BoardCell> targets;
	private Map<BoardCell, LinkedList<BoardCell>> adjMtx;
	private BoardCell[][] board;
	
	public void loadBoardConfig(){
		
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
