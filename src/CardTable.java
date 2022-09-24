import java.util.Random;

public class CardTable{
    private Queue<Player> players;
    private Deck deck;
    private Queue<Card> cards;

    private Random random = new Random();

    /**
     * Create card table with specified number of players 
     * Card table will have deck, it will open deck and get cards
     * @param numberOfPlayers
     */
    CardTable(int numberOfPlayers) {
        deck = new Deck();
        players = new Queue<Player>();
        for (int i = 0; i < numberOfPlayers; i++){
            players.enqueue(new Player("Player "+(i+1)));
        }
        cards = deck.getCards();
    }

    /*
     * it will shuffle cards by taking each card and swaping it with random card in cards
     */
    public void shuffleCards(){
        Node previous = null;
        Node current = cards.head;
        while(current != null){
            int tempRandom = random.nextInt() % 52;
            Node prv = null;
            Node temp = cards.head;
            for (int i = 0; i < tempRandom; i++) {
                prv = temp;
                temp = temp.next;
            }
            if (previous != temp && current != temp && prv != current) {
                if (previous != null) previous.next = temp;
                else cards.head = temp;

                if (prv != null) prv.next = current;
                else cards.head = current;

                Node newNode = current.next;
                current.next = temp.next;
                temp.next = newNode;

                previous = previous == null ? temp : previous.next;
                current = temp.next;
            }
        }
    }

    /*
     * each player will show their cards
     */
    public void showCards(){
        Node current = players.head;
        while (current != null) {
            Player currentPlayer = (Player) current.element;
            System.out.println("");
            System.out.println(currentPlayer.playerName+" cards are :");
            System.out.println(currentPlayer.cards.toString());
            current = current.next;
        }
    }

    /*
     * distribute card to each player one after another up cards not empty
     */
    public void distribute() {
        Node current = null;
        while (true) {
            current = current == null ? players.head : current;
            Card gotCard = (Card) cards.deque();
            Player currentPlayer = (Player) current.element;
            if (gotCard == null) break;
            else currentPlayer.takeCard(gotCard);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Card Table");
        CardTable cardTable = new CardTable(4);
        System.out.println("Card Table created");
        cardTable.shuffleCards();
        cardTable.shuffleCards();
        cardTable.shuffleCards();
        System.out.println("Cards tables cards shuffled");
        cardTable.distribute();
        System.out.println("Cards Distributed");
        cardTable.showCards();
	}

}