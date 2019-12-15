package shuffleStrategy;

import main.Card;

import java.util.ArrayList;
import java.util.Random;

public class ShuffleBySuit implements ShuffleStrategy {
    @Override
    public ArrayList<Card> shuffle(ArrayList<Card> cards) {

        ArrayList<Card> newCardDeck = new ArrayList<Card>();
        Random rand = new Random();
        int cardIndex = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cardIndex = rand.nextInt(13 - j);
                newCardDeck.add(cards.get(cardIndex));
                cards.remove(cardIndex);
            }
        }

        return newCardDeck;
    }
}
