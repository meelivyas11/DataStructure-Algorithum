package CardGame;

public class Card {
	
	String suit4;
	String numStr;
	Card next = null;
	
	public Card(String s, String n)
	{
		suit4 = s;
		numStr = n;
	}
}
