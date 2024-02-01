package contacts.command;

import contacts.ConsoleHelper;
import contacts.Main;
import contacts.contact.Contact;
import contacts.PhoneBook;

import java.util.List;

public abstract class AbstractCommand implements Command {
    static PhoneBook phoneBook = PhoneBook.getInstance();
    List<Contact> contacts = phoneBook.getContacts();
    String fileName = Main.getFileName();

    public void listAllRecords() {
        for (int i = 0; i < contacts.size(); i++) {
            ConsoleHelper.writeMessage(String.format("%d. %s %s", i + 1, contacts.get(i).getName(),
                    contacts.get(i).getSurname()).trim());
            ConsoleHelper.writeMessage("\n");
        }
        ConsoleHelper.writeMessage("\n");
    }

    public abstract void execute();
}
