package contacts.command;

import contacts.CommandExecutor;
import contacts.ConsoleHelper;
import contacts.MenuScreen;
import contacts.Operation;
import contacts.contact.Contact;

import java.util.ArrayList;
import java.util.List;

public class SearchCommand extends AbstractCommand {
    static List<Contact> searchResult = new ArrayList<>();

    @Override
    public void execute() {
        searchResult.clear();
        phoneBook.setUseDefaultContacts(false);
        ConsoleHelper.writeMessage("Enter search query: ");
        String query = ConsoleHelper.readString();
        for (Contact contact: contacts) {
            if (contact.showInfo().toLowerCase().contains(query.toLowerCase())) {
                searchResult.add(contact);
            }
        }

        if (searchResult.size() == 0 || searchResult.size() == 1) {
            ConsoleHelper.writeMessage(String.format("Found %d result.\n", searchResult.size()));
        } else {
            ConsoleHelper.writeMessage(String.format("Found %d results.\n", searchResult.size()));
        }

        if (searchResult.size() > 0) {
            for (int i = 0; i < searchResult.size(); i++) {
                ConsoleHelper.writeMessage(String.format("%d. %s %s", i + 1, searchResult.get(i).getName(),
                        searchResult.get(i).getSurname()).trim());
                ConsoleHelper.writeMessage("\n");
            }
            ConsoleHelper.writeMessage("\n");
        }

        Operation operation = MenuScreen.searchMenu();
        if (operation != null) {
            CommandExecutor.execute(operation);
        }
    }

    public static List<Contact> getSearchResult() {
        return searchResult;
    }
}
