package clueGame;

public class Suggestion {
	private String player;
	private BoardCell room;
	private String weapon;
	
	public Suggestion(){
		super();
	}
	
	@Override
	public boolean equals(Object suggestion){
		Suggestion suggestion2 = (Suggestion)suggestion;
		
		if(suggestion2.getPlayer().equals(this.getPlayer())
			&& suggestion2.getRoom().equals(this.getRoom())
			&& suggestion2.getWeapon().equals(this.getWeapon())){
			return true;
		}
		
		return false;
	}
	public Suggestion(String player, BoardCell room, String weapon){
		this.player = player;
		this.room = room;
		this.weapon = weapon;
	}
	
	public String getPlayer(){
		return this.player;
	}
	
	public BoardCell getRoom(){
		return this.room;
		
	}
	
	public String getWeapon(){
		return this.weapon;
	}
}
