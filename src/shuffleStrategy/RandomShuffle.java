package shuffleStrategy;

import main.Card;

import java.util.ArrayList;
import java.util.Random;

public class RandomShuffle implements ShuffleStrategy {
    @Override
    public ArrayList<Card> shuffle(ArrayList<Card> cards) {

        ArrayList<Card> newCardDeck = new ArrayList<Card>();
        Random rand = new Random();
        int cardIndex = 0;
        for (int i = 0; i < 52; i++) {
            cardIndex = rand.nextInt((cards.size() - 1) + 1);
            newCardDeck.add(cards.get(cardIndex));
            cards.remove(cardIndex);
        }

        return newCardDeck;
    }
}
