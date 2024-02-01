package contacts;

import contacts.contact.Contact;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private List<Contact> contacts = new ArrayList<>();
    private static int index;
    private static int recordIndex;
    private boolean useDefaultContacts;
    private static PhoneBook instance;

    private PhoneBook() {

    }

    public static PhoneBook getInstance() {
        if (instance == null) {
            return new PhoneBook();
        }
        return instance;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getRecordIndex() {
        return recordIndex;
    }

    public void setRecordIndex(int recordIndex) {
        this.recordIndex = recordIndex;
    }

    public boolean isUseDefaultContacts() {
        return useDefaultContacts;
    }

    public void setUseDefaultContacts(boolean useDefaultContacts) {
        this.useDefaultContacts = useDefaultContacts;
    }

    public void saveContacts(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            if (!("".equals(fileName))) {
                oos.writeObject(contacts);
            }
        } catch (IOException e) {

        }
    }
}
