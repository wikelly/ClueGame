package clueGame;

import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Board {
	private int numRows, numColumns;
	private Set<BoardCell> targets;
	private Map<BoardCell, LinkedList<BoardCell>> adjMtx;
	
	public void loadBoardConfig(Map<Character, String> a){
		
	}
	public void calcTargets(){
		
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
}
