package clueGame;

import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JPanel;


public class Board extends JPanel{
	private int numRows, numColumns;
	private int rectSize = 30;
	private static int rowpix, colpix;
	private Map<Character, String> rooms;
	private Set<BoardCell> targets = new HashSet<BoardCell>();
	private Set<BoardCell> visited = new HashSet<BoardCell>();
	private Map<BoardCell, LinkedList<BoardCell>> adjMtx = new HashMap<BoardCell, LinkedList<BoardCell>>();
	public BoardCell[][] board;
	//private Graphics g;
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
					board[i][j].setRow(i);
					board[i][j].setColumn(j);
					
				}
				i=i+1;
			}
			fin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rowpix = numRows;
		colpix =numColumns;
		
	}
	
	public void calcTargets(int row, int col, int diceRoll){
		targets = new HashSet<BoardCell>();
		visited = new HashSet<BoardCell>();
		calcAllTargets(row, col, diceRoll);
	}
	
	public void calcAllTargets(int row, int col, int numSteps){
		BoardCell a;// = new BoardCell();
		a = getBoardCellAt(row, col);
		visited.add(a);
		LinkedList<BoardCell> tmp = new LinkedList<BoardCell>(adjMtx.get(a));
		tmp.removeAll(visited);
		for (BoardCell c : tmp){
			visited.add(c);
			if ((numSteps == 1)||(c.isDoorway())){
				targets.add(c);
			}else {
				calcAllTargets(c.getRow(),c.getColumn(), numSteps-1);
			}
			visited.remove(c);
		}
	}
	
	public int getNumRows() {
		return numRows;
	}
	public int getNumColumns() {
		return numColumns;
	}
	public void calcAdjacencies(){
		for (int i = 0; i < numRows; i++){
			for (int j = 0; j < numColumns; j++){
				LinkedList<BoardCell> tmp = new LinkedList<BoardCell>();
				if (getBoardCellAt(i, j).isDoorway()){
					if (i+1 < numRows) {
						if (getBoardCellAt(i+1, j).isWalkway()&&getBoardCellAt(i, j).dd==DoorDirection.DOWN)
							tmp.add(getBoardCellAt(i+1, j));
					}
					if (i-1 > -1) {
						if (getBoardCellAt(i-1, j).isWalkway()&&getBoardCellAt(i, j).dd==DoorDirection.UP)
							tmp.add(getBoardCellAt(i-1, j));
					}
					if (j+1 < numColumns) {
						if (getBoardCellAt(i, j+1).isWalkway()&&getBoardCellAt(i, j).dd==DoorDirection.RIGHT)
							tmp.add(getBoardCellAt(i, j+1));
					}
					if (j-1 > -1) {
						if (getBoardCellAt(i, j-1).isWalkway()&&getBoardCellAt(i, j).dd==DoorDirection.LEFT)
							tmp.add(getBoardCellAt(i, j-1));
					}
				}else if(!getBoardCellAt(i, j).isRoom() ){
					if (i+1 < numRows) {
						if (getBoardCellAt(i+1, j).isWalkway()||(getBoardCellAt(i+1, j).isDoorway()&&getBoardCellAt(i+1, j).dd==DoorDirection.UP))
							tmp.add(getBoardCellAt(i+1, j));
					}
					if (i-1 > -1) {
						if (getBoardCellAt(i-1, j).isWalkway()||(getBoardCellAt(i-1, j).isDoorway()&&getBoardCellAt(i-1, j).dd==DoorDirection.DOWN))
							tmp.add(getBoardCellAt(i-1, j));
					}
					if (j+1 < numColumns) {
						if (getBoardCellAt(i, j+1).isWalkway()||(getBoardCellAt(i, j+1).isDoorway()&&getBoardCellAt(i, j+1).dd==DoorDirection.LEFT))
							tmp.add(getBoardCellAt(i, j+1));
					}
					if (j-1 > -1) {
						if (getBoardCellAt(i, j-1).isWalkway()||(getBoardCellAt(i, j-1).isDoorway()&&getBoardCellAt(i, j-1).dd==DoorDirection.RIGHT))
							tmp.add(getBoardCellAt(i, j-1));
					}
				}
				adjMtx.put(getBoardCellAt(i, j), tmp);
			}
		}
	}
	public Set<BoardCell> getTargets(){
		return targets;
	}
	public LinkedList<BoardCell> getAdjList(int row, int column){
		return adjMtx.get(getBoardCellAt(row,column));
		
	}
	public BoardCell getBoardCellAt(int row, int col){
		return board[row][col];
		
	}
	public Map<Character, String> getRooms() {
		return rooms;
	}
	public RoomCell getRoomCellAt(int row, int col){
		return (RoomCell) board[row][col];
		
	}
	public void setRooms(Map<Character, String> rooms) {
		this.rooms = rooms;
	}
	
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.RED);
		//BoardCell bc;
		
		for(int i = 0; i< rowpix; i++){
			for(int j = 0; j<colpix; j++){
				//BoardCell bc =getBoardCellAt(i, j);
				//bc.draw(g, this);
				//bc = board[i][j];
				//bc.draw(g, this);
				//board[i][j].draw(g, this);
				
					
				g.setColor(Color.GRAY);
				g.fillRect(i*rectSize, j*rectSize, rectSize, rectSize);
				g.setColor(Color.WHITE);
				g.drawRect(i*rectSize, j*rectSize, rectSize, rectSize);
				
			}
			for(Player x: ClueGame.getGamePlayers()){
				x.draw(g, this);
			}
		}
		g.setColor(Color.BLUE);
		Font font = new Font("Dialog", Font.BOLD, 15);
		g.setFont(font);
		g.drawString("Conservatory", 0*rectSize, 1*rectSize);
		g.drawString("Billiard room", 6*rectSize, 1*rectSize);
		g.drawString("Ballroom", 0*rectSize, 9*rectSize);
		g.drawString("Kitchen", 0*rectSize, 16*rectSize);
		g.drawString("Dining Room", 9*rectSize, 19*rectSize);
		g.drawString("Lounge", 19*rectSize, 19*rectSize);
		g.drawString("Hall", 17*rectSize, 13*rectSize);
		g.drawString("Library", 16*rectSize, 2*rectSize);
		g.drawString("Study", 20*rectSize, 2*rectSize);
		//g.fillRect(20, 20, 40, 40);
	
	}

	
}
