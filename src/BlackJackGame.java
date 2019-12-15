import java.util.ArrayList;

public class BlackJackGame {
    public static void main(String[] args) {

        Deck gameDeck = new Deck();
        gameDeck.create();

        GameSetup setup = new GameSetup(1, 5);

        ConsoleOutput output = new ConsoleOutput();
        ConsoleInputReader inputReader = new ConsoleInputReader();

        Player dealer = new Player("Dealer", new Deck());
        ArrayList<Player> players = setup.createPlayers();


        while (players.get(0).getMoney() > 0 && players.get(0) != null) {

            gameDeck.shuffle();

            addBets(players);
            drawCards(players, dealer, gameDeck);

            for (Player player : players) {
                System.out.println(player.getMoney());
            }

            output.print("Dealer cards: " + dealer.getDeck().getCard(0).toString() + " + {Hidden}");

            makeMoves(players, gameDeck);

            output.print("Dealers cards: " + dealer.getDeck().toString() + ", hand value - " + dealer.getDeck().cardsValue());
            drawDealerCards(dealer, gameDeck);

            showResults(players, dealer, gameDeck);

            for (Player player : players) {
                System.out.println(player.getMoney());
            }
            moveCardsToMainDeck(players, dealer, gameDeck);
        }
    }

    private static void moveCardsToMainDeck(ArrayList<Player> players, Player dealer, Deck gameDeck) {
        for (Player player : players) {
            player.getDeck().moveCardsToDeck(gameDeck);
        }

        dealer.getDeck().moveCardsToDeck(gameDeck);
    }

    private static void drawDealerCards(Player dealer, Deck gameDeck) {
        ConsoleOutput output = new ConsoleOutput();

        while (dealer.getDeck().cardsValue() < 17) {
            dealer.getDeck().drawCard(gameDeck);
            output.print("Dealer got " + dealer.getDeck().getCard(dealer.getDeck().getDeckSize() - 1));
            output.print("Dealers cards: " + dealer.getDeck().toString() + ", hand value - " + dealer.getDeck().cardsValue());
        }
    }

    private static void showResults(ArrayList<Player> players, Player dealer, Deck gameDeck) {

        ConsoleOutput output = new ConsoleOutput();

        for (Player player : players) {
            if (player.getDeck().cardsValue() <= 21 && (player.getDeck().cardsValue() > dealer.getDeck().cardsValue() || dealer.getDeck().cardsValue() > 21)) {
                output.print(player.getName() + " won against dealer");
                player.addMoney();
            } else if (player.getDeck().cardsValue() == dealer.getDeck().cardsValue() && player.getDeck().cardsValue() <= 21) {
                output.print(player.getName() + " you got Draw");
            } else {
                output.print(player.getName() + " you lost.");
                player.removeMoney();
            }
        }
    }

    private static void makeMoves(ArrayList<Player> players, Deck gameDeck) {

        ConsoleOutput output = new ConsoleOutput();
        ConsoleInputReader inputReader = new ConsoleInputReader();

        for (Player player : players) {
            int move = 0;
            boolean roundIsOver = false;
            while (!roundIsOver) {
                output.print(player.getName() + " cards are " + player.getDeck().toString() + ", hand value - " + player.getDeck().cardsValue());
                output.print("Would you like to hit (1) or stand (2)?");
                move = inputReader.readUserIntegerInput();

                if (move == 1) {
                    player.getDeck().drawCard(gameDeck);
                    output.print("You got " + player.getDeck().getCard(player.getDeck().getDeckSize() - 1));
                    if (player.getDeck().cardsValue() > 21) {
                        output.print("You lost a game. Your cards value are - " + player.getDeck().cardsValue());
                        roundIsOver = true;
                    }
                }

                if (move == 2) {
                    output.print("You select stand");
                    roundIsOver = true;
                }
            }
        }
    }

    private static void drawCards(ArrayList<Player> players, Player dealer, Deck gameDeck) {
        dealer.getDeck().drawCard(gameDeck);
        dealer.getDeck().drawCard(gameDeck);

        for (Player player : players) {
            player.getDeck().drawCard(gameDeck);
            player.getDeck().drawCard(gameDeck);
        }
    }

    private static void addBets(ArrayList<Player> players) {

        ConsoleOutput output = new ConsoleOutput();
        ConsoleInputReader inputReader = new ConsoleInputReader();

        int bet = 0;
        for (Player player : players) {
            output.print(player.getName() + " you have " + player.getMoney() + "$, how much would you like to bet?");
            do {
                bet = inputReader.readUserIntegerInput();
                if (bet > player.getMoney()) {
                    output.print("You don't have enough money.");
                }
            } while (player.getMoney() < bet);

            player.addBet(bet);
            output.print("Bet was successfully placed.");
        }
    }
}