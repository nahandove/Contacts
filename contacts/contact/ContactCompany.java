package contacts.contact;

import contacts.ConsoleHelper;

import java.time.format.DateTimeFormatter;

public class ContactCompany extends Contact {
    public ContactCompany(String name) {
        super(name);
    }

    @Override
    public Contact setAddress() {
        ConsoleHelper.writeMessage("Enter address: ");
        this.address = ConsoleHelper.readString();
        return this;
    }

    @Override
    public String showAvailableFields() {
        return super.showAvailableFields() + "(name, address, number): ";
    }

    @Override
    public String showInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return "Organization name: " + getName() + "\n"
                + "Address: " + getAddress() + "\n"
                + "Number: " + getPhoneNumber() + "\n"
                + "Time created: " + formatter.format(getTimeCreated()) + "\n"
                + "Time last edit: " + formatter.format(getTimeLastEdit()) + "\n\n";
    }
}
