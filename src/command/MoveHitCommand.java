package command;

import java.awt.event.MouseEvent;

public class MoveHitCommand implements Command {

    Move move;

    public MoveHitCommand(Move move) {
        this.move = move;
    }

    @Override
    public void execute() {
        this.move.hit();
    }
}
