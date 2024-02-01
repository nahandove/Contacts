package contacts.command;

import contacts.CommandExecutor;
import contacts.MenuScreen;
import contacts.Operation;

public class ListCommand extends AbstractCommand {
    @Override
    public void execute() {
        super.listAllRecords();
        phoneBook.setUseDefaultContacts(true);
        Operation operation = MenuScreen.listMenu();
        if (operation != null) {
            CommandExecutor.execute(operation);
        }
    }
}
