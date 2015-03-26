package clueGame;

import java.awt.*;



public class Walkway extends BoardCell{

	
	@Override
	public boolean isWalkway() {
		// TODO Auto-generated method stub
		return true;
	}
	

	public void draw(Graphics g, Board b) {
		g.setColor(Color.RED);
		g.fillRect(getRow()*20, getColumn()*20, 20, 20);
		g.setColor(Color.BLACK);
		g.drawRect(getRow()*rectSize,getColumn()*rectSize,rectSize,rectSize);
		
	}
	
	
}
