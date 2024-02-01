package contacts.contact;

import contacts.ConsoleHelper;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Contact implements Serializable {
    protected String name;
    protected String surname = "";
    protected String phoneNumber = "";
    protected String birthDate = "";
    protected String gender = "";
    protected String address = "";
    protected LocalDateTime timeCreated = LocalDateTime.now();
    protected LocalDateTime timeLastEdit = LocalDateTime.now();

    public Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public LocalDateTime getTimeLastEdit() {
        return timeLastEdit;
    }

    public void setName() {
        ConsoleHelper.writeMessage("Enter name: ");
        this.name = ConsoleHelper.readString();
    }

    public Contact setSurname() {
        return this;
    }

    public Contact setBirthDate() {
        return this;
    }

    public Contact setGender() {
        return this;
    }

    public Contact setPhoneNumber() {
        ConsoleHelper.writeMessage("Enter number: ");
        this.phoneNumber = ConsoleHelper.readString();
        if (!isPhoneNumberValid(phoneNumber)) {
            ConsoleHelper.writeMessage("Wrong number format!\n");
            this.phoneNumber = "[no number]";
        }
        return this;
    }

    public Contact setAddress() {
        return this;
    }

    public Contact setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
        return this;
    }

    public Contact setTimeLastEdit(LocalDateTime timeLastEdit) {
        this.timeLastEdit = timeLastEdit;
        return this;
    }

    public String showAvailableFields() {
        return "Select a field ";
    }

    public abstract String showInfo();

    private boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.matches("[+]?[A-Za-z0-9]+([ -][A-Za-z0-9]{2,})*")
                || phoneNumber.matches("[+]?[(][A-Za-z0-9]+[)]([ -][A-Za-z0-9]{2,})*")
                || phoneNumber.matches("[+]?[A-Za-z0-9]+[ -][(][A-Za-z0-9]{2,}[)]([ -][A-Za-z0-9]{2,})*");
    }
}
