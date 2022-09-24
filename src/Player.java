public class Player implements Comparable<Player>{
    public Queue<Card> cards = new Queue<Card>();
    public String playerName;

    /**
	 * create player with player name and cards of player
	 * @param rank
	 * @param suit
	 */
    Player(String playerName) {
        this.playerName = playerName;
    }

    /**
     * take card and insert that card in appropriate position in cards in sorting manner
     * @param card
     */
    public void takeCard(Card card){
        cards.insertSort(card);
    }

    /**
     * currently always returing 0
     * that is showing this player and parameter player are same in comparision
     * @param player
     * @return 0
     */
     @Override
    public int compareTo(Player player) {
        return 0;
    }

}
