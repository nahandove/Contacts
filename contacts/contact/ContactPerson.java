package contacts.contact;

import contacts.ConsoleHelper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ContactPerson extends Contact {
    public ContactPerson(String name) {
        super(name);
    }

    @Override
    public Contact setSurname() {
        ConsoleHelper.writeMessage("Enter surname: ");
        this.surname = ConsoleHelper.readString();
        return this;
    }

    @Override
    public Contact setGender() {
        ConsoleHelper.writeMessage("Enter gender (M, F): ");
        this.gender = ConsoleHelper.readString();
        if (gender.isEmpty() || (!"M".equals(gender) && !"F".equals(gender))) {
            ConsoleHelper.writeMessage("Bad gender!\n");
            this.gender = "[no data]";
        }
        return this;
    }

    @Override
    public Contact setBirthDate() {
        ConsoleHelper.writeMessage("Enter birth date: ");
        birthDate = ConsoleHelper.readString();
        try {
            LocalDate date = LocalDate.parse(birthDate);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.birthDate = formatter.format(date);
        } catch (DateTimeParseException e) {
            ConsoleHelper.writeMessage("Bad birth date!\n");
            this.birthDate = "[no data]";
        }
        return this;
    }

    @Override
    public String showAvailableFields() {
        return super.showAvailableFields() + "(name, surname, birth, gender, number): ";
    }

    @Override
    public String showInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return "Name: " + getName() + "\n"
                + "Surname: " + getSurname() + "\n"
                + "Birth date: " + getBirthDate() + "\n"
                + "Gender: " + getGender() + "\n"
                + "Number: " + getPhoneNumber() + "\n"
                + "Time created: " + formatter.format(getTimeCreated()) + "\n"
                + "Time last edit: " + formatter.format(getTimeLastEdit()) + "\n\n";
    }
}
