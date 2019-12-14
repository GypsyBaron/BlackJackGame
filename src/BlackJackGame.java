public class BlackJackGame {
    public static void main (String[] args) {
        
        Deck fullDeck = new Deck();
        // Shouldn't this be in constructor?
        fullDeck.createDeck();
        fullDeck.shuffle();

        Player player = new Player(new Deck());
        Player dealer = new Player(new Deck());

    }
}
