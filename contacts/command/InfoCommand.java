package contacts.command;

import contacts.*;
import contacts.contact.Contact;

import java.util.List;

public class InfoCommand extends AbstractCommand {
    List<Contact> allContacts;

    @Override
    public void execute() {
        if (phoneBook.isUseDefaultContacts()) {
            allContacts = contacts;
        } else {
            allContacts = SearchCommand.getSearchResult();
        }
        try {
            showInfo(phoneBook.getIndex() - 1);
            phoneBook.setRecordIndex(findRecordIndex());
            Operation operation = MenuScreen.recordMenu();
            if (operation != null) {
                CommandExecutor.execute(operation);
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            ConsoleHelper.writeMessage("Invalid index.\n\n");
        } catch (IllegalArgumentException e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }

    private void showInfo(int index) {
        ConsoleHelper.writeMessage(allContacts.get(index).showInfo());
    }

    public int findRecordIndex() {
        if (phoneBook.isUseDefaultContacts()) {
            phoneBook.setRecordIndex(phoneBook.getIndex() - 1);
        } else {
            Contact contact = allContacts.get(phoneBook.getIndex() - 1);
            for (int i = 0; i < contacts.size(); i++) {
                if (contacts.get(i).equals(contact)) {
                    phoneBook.setRecordIndex(i);
                }
            }
        }
        return phoneBook.getRecordIndex();
    }
}
