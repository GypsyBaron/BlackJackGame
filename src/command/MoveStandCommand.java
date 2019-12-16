package command;

import main.BlackJackGame;
import main.Deck;
import main.Player;

public class MoveStandCommand implements Command{

    private Move move;

    public MoveStandCommand(Move move) {
        this.move = move;
    }

    @Override
    public void execute() {
        this.move.stand();
    }
}
