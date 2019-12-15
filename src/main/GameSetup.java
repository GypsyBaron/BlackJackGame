package main;

import java.util.ArrayList;

public class GameSetup {

    private int minPlayer;
    private int maxPlayer;
    ConsoleOutput output = new ConsoleOutput();
    ConsoleInputReader inputReader = new ConsoleInputReader();

    public GameSetup(int minPlayer, int maxPlayer) {
        this.minPlayer = minPlayer;
        this.maxPlayer = maxPlayer;
    }

    public int getNumberOfPlayers() {
        int players = 0;

        output.print("Enter the number of players [" + minPlayer + "-" + maxPlayer + "]:");
        while (true)  {
            players = inputReader.readUserIntegerInput();
            if (!isNumberOfPlayersCorrect(players)) {
                output.print("Invalid number of players. Try again");
            } else {
                break;
            }
        }

        return players;
    }

    public boolean isNumberOfPlayersCorrect(int players) {
        return players >= minPlayer && maxPlayer >= players;
    }

    public ArrayList<Player> createPlayers() {
        int playerCounter = 0;
        ArrayList<Player> players = new ArrayList<>();
        playerCounter = getNumberOfPlayers();

        for (int i = 0; i < playerCounter; i++) {
            String playerName = "Player " + (i+1);
            Player player = new Player(playerName, new Deck());
            players.add(player);
        }

        return players;
    }
}
