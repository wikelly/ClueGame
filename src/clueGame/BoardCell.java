package clueGame;

import java.awt.Color;
import java.awt.Graphics;

public class BoardCell {
	private int row, column;
	protected DoorDirection dd;
	protected int rectSize = 30;
	
	
	public boolean isWalkway(){
		return false;	
	}
	public boolean isRoom(){
		return false;
	}
	public boolean isDoorway(){
		return false;
	}
	// Add method draw when making GUI
	public int getRow() {
		return row;
	}
	public int getColumn() {
		return column;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	
	protected void draw(Graphics g, Board b){
		
	}
	/*void draw(java.awt.Graphics g, int rowpix, int colpix) {
		g.setColor(Color.RED);
		g.fillRect(20, 20, 20, 20);
		g.drawRect(20,20,20,20);
	}*/
	//abstract void draw(Graphics g, int rowpix, int colpix);
}
