import java.util.ArrayList;
import java.util.Random;

public class Deck {

    // I would initialise this here instead of constructor
    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    // word 'Deck' is unnecessary
    public void createDeck() {
        for (CardSuit cardSuit : CardSuit.values()) {
            for (CardValue cardValue : CardValue.values()) {
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
    }

    public void shuffle() {
        // Don't use shortened words, no need to use word 'Deck' in variable name
        // I would do it like this:
        // List<Card> newCards = new ArrayList<>();
        ArrayList<Card> tempCardDeck = new ArrayList<Card>();
        // Needs dependency injection
        Random rand = new Random();
        // I would still initialize with zero
        int cardIndex;
        // I would extract loop body into new method
        for (int i = 0; i < 52; i++) {
            // Extract nextInt parameter into explanatory variable
            cardIndex = rand.nextInt((this.cards.size() - 1) + 1);
            // Same as above
            tempCardDeck.add(this.cards.get(cardIndex));
            this.cards.remove(cardIndex);
        }

        this.cards = tempCardDeck;
    }

    public String toString() {
        return cards.toString();
    }

    public void removeCard(int i) {
        this.cards.remove(i);
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public Card getCard(int i) {
        return this.cards.get(i);
    }

    // This method looks strange
    public void drawCard(Deck userDeck) {
        this.cards.add(userDeck.getCard(0));
        userDeck.removeCard(0);
    }

}
