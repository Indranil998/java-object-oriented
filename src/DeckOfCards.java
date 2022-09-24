import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DeckOfCards {
	// Card properties ranks and suits card will have any of one rank from these ranks and any of one suit from these suits
	static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	static String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
	// Deck it is list of cards it will have 52 cards
	static ArrayList<Card> deck = new ArrayList<Card>();
	// use for shuffle
	static Random random = new Random();
	static ArrayList<ArrayList> players =  new ArrayList<ArrayList>();
	static int numberOfPlayers = 4;
	static int cardsToDistribute = 9;
	
	/*
	 * it is arrangement of cards so deck will have every unique 52 cards it is sequential arrangement
	 */
	public static void makeDeck() {
		// it is arrangement of ranks and suits
		for (int i = 0; i < (ranks.length * suits.length); i++) {
			// from i - 0 to 12 :- Clubs of each ranks 
			// from i - 13 to 25 :- Diamonds of each ranks 
			// from i - 26 to 38 :- Hearts of each ranks 
			// from i - 39 to 52 :- Spades of each ranks 
			deck.add(new Card(ranks[i % ranks.length], suits[i / ranks.length]));
		}
	}
	
	/*
	 * Show what cards in deck
	 */
	public static void showDeck() {
		System.out.println(deck.toString());
	}
	
	public static void shuffleDeck() {
		Collections.shuffle(deck);
	}
	
	public static void makeTable(int numberOfPlayers) {
		for (int i = 0; i < numberOfPlayers; i++) {
			players.add(new ArrayList<Card>());
		}
	}
	
	/*
	 * distribute cards to each player in equal quantity
	 */
	public static void distribute() {
		for (int i = 1; i <= cardsToDistribute; i++)	// loop to how many cards to distribute to each player
			for (int j = 0; j < players.size(); j++)	// distribute ith card to every player one by one
				if(!deck.isEmpty()) {					// check is deck empty if not empty then distribute
					Card tempCard = deck.get(0); 
					deck.remove(0);						// get first card from deck now it will not be in deck 
					players.get(j).add(tempCard);		// distribute that card to specified player
				}
				else break;
	}
	
	public static void showPlayers() {
		for (int j = 0; j < players.size(); j++) {
			System.out.println("");
			System.out.println("Player "+(j+1)+" cards are : ");
			System.out.println(players.get(j).toString());
		}
	}
	
	public static void main(String[] args) {
		makeDeck();
		shuffleDeck();
		showDeck();
		makeTable(numberOfPlayers);
		distribute();
		showPlayers();
	}

}