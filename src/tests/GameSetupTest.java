package tests;

import main.GameSetup;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameSetupTest {

    @Test
    public void isNumberOfPlayersCorrectTest () {

        GameSetup gameSetup = new GameSetup(1, 6);

        boolean result = gameSetup.isNumberOfPlayersCorrect(3);

        assertEquals(result, true);
    }
}
