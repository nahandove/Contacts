package contacts.command;

public class ExitCommand extends AbstractCommand {
    @Override
    public void execute() {
        System.exit(0);
    }
}
