package contacts.command;

import contacts.ConsoleHelper;
import contacts.contact.Contact;
import contacts.contact.ContactCompany;
import contacts.contact.ContactPerson;

import java.time.LocalDateTime;

public class AddCommand extends AbstractCommand {
    @Override
    public void execute() {
        ConsoleHelper.writeMessage("Enter the type (person, organization): ");
        String type = ConsoleHelper.readString();
        if ("person".equals(type)) {
            createPerson();
        } else if ("organization".equals(type)) {
            createOrganization();
        } else {
            ConsoleHelper.writeMessage("Unknown type.\n");
        }
        phoneBook.saveContacts(fileName);
        ConsoleHelper.writeMessage("The record added.\n\n");
    }

    private void createPerson() {
        ConsoleHelper.writeMessage("Enter the name: ");
        Contact contact = new ContactPerson(ConsoleHelper.readString())
                .setSurname()
                .setBirthDate()
                .setGender()
                .setPhoneNumber()
                .setTimeCreated(LocalDateTime.now())
                .setTimeLastEdit(LocalDateTime.now());
        contacts.add(contact);
    }

    private void createOrganization() {
        ConsoleHelper.writeMessage("Enter the organization name: ");
        Contact contact = new ContactCompany(ConsoleHelper.readString())
                .setAddress()
                .setPhoneNumber()
                .setTimeCreated(LocalDateTime.now())
                .setTimeLastEdit(LocalDateTime.now());
        contacts.add(contact);
    }
}
