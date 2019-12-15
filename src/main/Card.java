package main;

import java.util.ArrayList;
import java.util.Random;

public class Card {

    private CardSuit cardSuit;
    private CardValue cardValue;

    public Card(CardSuit cardSuit, CardValue cardValue) {
        this.cardSuit = cardSuit;
        this.cardValue = cardValue;
    }

    public CardValue getCardValue() {
        return this.cardValue;
    }

    public String toString() {
        return this.cardSuit.toString() + "_" + this.cardValue.toString();
    }
}
