public class Deck {
	public static final String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	public static final String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
	
	private Queue<Card> cards = new Queue<Card>();
	
	/*
	 * will create deck with 52 cards in it
	 * 13 cards of Clubs,
	 * 13 cards of Diamonds,
	 * 13 cards of Hearts,
	 * 13 crads of Spades,
	 */
	Deck() {
		// it is arrangement of ranks and suits
		for (int i = 0; i < (ranks.length * suits.length); i++) {
			// from i - 0 to 12 :- Clubs of each ranks 
			// from i - 13 to 25 :- Diamonds of each ranks 
			// from i - 26 to 38 :- Hearts of each ranks 
			// from i - 39 to 52 :- Spades of each ranks 
			cards.enqueue(new Card(ranks[i % ranks.length], suits[i / ranks.length]));
		}
	}

	/**
	 * gives rank priority of rank in decks all ranks
	 * @param rank
	 * @return rank priority in deck
	 */
	public static int rankPriority(String rank) {
		for (int i = 0; i < Deck.ranks.length; i++) if (rank == Deck.ranks[i]) return i;
		return -1;
	}

	public Queue getCards(){
		return cards;
	}
	
	/*
	 * Show what cards in deck
	 */
	public void showCards() {
		System.out.println(cards.toString());
	}
}