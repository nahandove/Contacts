package contacts.command;

import contacts.*;

public class RemoveCommand extends AbstractCommand {

    @Override
    public void execute() {
        if (contacts.size() == 0) {
            ConsoleHelper.writeMessage("No records to remove!\n\n");
        } else {
            try {
                contacts.remove(phoneBook.getRecordIndex());
                phoneBook.saveContacts(fileName);
                ConsoleHelper.writeMessage("The record removed!\n\n");
                Operation operation = MenuScreen.recordMenu();
                if (operation != null) {
                    CommandExecutor.execute(operation);
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                ConsoleHelper.writeMessage("Invalid index.\n\n");
            }
        }
    }
}
