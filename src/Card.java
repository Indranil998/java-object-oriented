public class Card implements Comparable<Card>{
	public String rank;
	public String suit;
	
	/**
	 * create card with rank and suit
	 * @param rank
	 * @param suit
	 */
	Card (String rank, String suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	/**
	 * return 1 if this cards ranks priority is greater than parameter cards ranks priority 
	 * -1 if this cards ranks priority is less than parameter cards ranks priority
	 * 0 if both cards ranks priority are same 
	 * @param card
	 * @return 1 or -1 or 0
	 */
	 @Override
	public int compareTo(Card card) {
		if(Deck.rankPriority(this.rank) > Deck.rankPriority(card.rank)) return 1;
		else if(Deck.rankPriority(this.rank) < Deck.rankPriority(card.rank)) return -1;
		else return 0;
	}

	public String toString() {
		return "\n"+rank+" "+suit;
	}
}