package command;

public class RemoteController {
    Command command;

    public void setCommand(Command command)
    {
        this.command = command;
    }

    public void playerSelectedMove()
    {
        command.execute();
    }
}
