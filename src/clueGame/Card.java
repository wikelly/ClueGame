package clueGame;

public class Card {
	private String name;
	private enum CardType {ROOM,WEAPON,PERSON}
	private CardType cardType;
	
	public Card(){
		super();
	}
	public Card(String name, CardType cardType) {
		super();
		this.name = name;
		this.cardType = cardType;
	}
	
	public boolean equals(Card otherCard){
		return false;
	}
	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	};
	
	
}
