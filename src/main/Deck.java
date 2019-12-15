package main;

import shuffleStrategy.ShuffleStrategy;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;
    private ShuffleStrategy shuffleStrategy;

    public Deck(ShuffleStrategy shuffleStrategy) {
        this.cards = new ArrayList<Card>();
        this.shuffleStrategy = shuffleStrategy;
    }

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
        cards = this.shuffleStrategy.shuffle(this.cards);
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
