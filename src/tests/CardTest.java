package tests;

import main.Card;
import main.CardSuit;
import main.CardValue;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void toStringTest() {

        Card card = new Card(CardSuit.HEARTS, CardValue.FIVE);

        String result = card.toString();

        assertEquals(result, "HEARTS_FIVE");
    }
}
