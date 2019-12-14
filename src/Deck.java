import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public void createDeck() {
        for (CardSuit cardSuit : CardSuit.values()) {
            for (CardValue cardValue : CardValue.values()) {
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
    }

    public void shuffle() {
        ArrayList<Card> tempCardDeck = new ArrayList<Card>();
        Random rand = new Random();
        int cardIndex;
        for (int i = 0; i < 52; i++) {
            cardIndex = rand.nextInt((this.cards.size() - 1) + 1);
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

    public void drawCard(Deck userDeck) {
        this.cards.add(userDeck.getCard(0));
        userDeck.removeCard(0);
    }

}
