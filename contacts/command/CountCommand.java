package contacts.command;

import contacts.ConsoleHelper;

public class CountCommand extends AbstractCommand {
    @Override
    public void execute() {
        ConsoleHelper.writeMessage(String.format("The Phone Book has %d records.\n", contacts.size()));
    }
}
