package shuffleStrategy;

import main.Card;

import java.util.ArrayList;

public interface ShuffleStrategy {
    public ArrayList<Card> shuffle(ArrayList<Card> cards);
}
