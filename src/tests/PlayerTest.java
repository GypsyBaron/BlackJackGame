package tests;

import main.Deck;
import main.Player;
import org.junit.Test;
import shuffleStrategy.RandomShuffle;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getMoneyTest() {
        Deck deck = new Deck(new RandomShuffle());
        Player player = new Player("Player", deck);

        int result = player.getMoney();

        assertEquals(result, 1000);
    }

    @Test
    public void getNameTest() {
        Deck deck = new Deck(new RandomShuffle());
        Player player = new Player("RandomOrg", deck);

        String result = player.getName();

        assertEquals(result, "RandomOrg");
    }
}
