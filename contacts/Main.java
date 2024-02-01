package contacts;

import contacts.contact.Contact;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Main {
    public static PhoneBook phoneBook = PhoneBook.getInstance();
    static String fileName = "";

    public static void main(String[] args) {
        if (args.length == 2 && "open".equals(args[0])) {
            fileName = args[1];
            try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            ) {
                List<Contact> importedContacts = (List<Contact>) ois.readObject();
                phoneBook.setContacts(importedContacts);
            } catch (ClassNotFoundException | IOException e) {
                ConsoleHelper.writeMessage("Something went wrong reading file");
            }
        }
        MenuScreen.start();
    }

    public static String getFileName() {
        return fileName;
    }
}
