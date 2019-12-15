import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public void create() {
        for (CardSuit cardSuit : CardSuit.values()) {
            for (CardValue cardValue : CardValue.values()) {
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
    }

    public void shuffle() {
        ArrayList<Card> newCardDeck = new ArrayList<Card>();
        Random rand = new Random();
        int cardIndex = 0;
        for (int i = 0; i < 52; i++) {
            cardIndex = rand.nextInt((this.cards.size() - 1) + 1);
            newCardDeck.add(this.cards.get(cardIndex));
            this.cards.remove(cardIndex);
        }

        this.cards = newCardDeck;
    }
    public int getDeckSize() {
        return this.cards.size();
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

    public int cardsValue() {
        int totalValue = 0;
        int acesCount = 0;
        for (Card card : this.cards) {
            switch (card.getCardValue()) {
                case ACE: acesCount++; break;
                case TWO: totalValue+= 2; break;
                case THREE: totalValue+= 3; break;
                case FOUR: totalValue+= 4; break;
                case FIVE: totalValue+= 5; break;
                case SIX: totalValue+= 6; break;
                case SEVEN: totalValue+= 7; break;
                case EIGHT: totalValue+= 8; break;
                case NINE: totalValue+= 9; break;
                case TEN:
                case JACK:
                case QUEEN:
                case KING: totalValue+= 10; break;
            }
        }

        for (int i = 0; i < acesCount; i++) {
            if (totalValue > 10) {
                totalValue+= 1;
            } else {
                totalValue+= 11;
            }
        }

        return totalValue;
    }

    public void moveCardsToDeck(Deck gameDeck) {
        int deckSize = this.cards.size();

        for (int i = 0; i < deckSize; i++) {
            gameDeck.addCard(this.cards.get(i));
        }

        for (int i = 0; i < deckSize; i++) {
            this.removeCard(0);
        }
    }
}
