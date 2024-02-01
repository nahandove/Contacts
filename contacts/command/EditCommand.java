package contacts.command;

import contacts.*;

import java.time.LocalDateTime;

public class EditCommand extends AbstractCommand {

    @Override
    public void execute() {
        if (contacts.size() == 0) {
            ConsoleHelper.writeMessage("No records to edit!\n");
        } else {
            try {
                edit(phoneBook.getRecordIndex());
                Operation operation = MenuScreen.recordMenu();
                if (operation != null) {
                    CommandExecutor.execute(operation);
                }
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage(e.getMessage());
            }
        }
    }

    private void edit(int index) {
        ConsoleHelper.writeMessage(contacts.get(index).showAvailableFields());
        String field = ConsoleHelper.readString();
        switch(field) {
            case "name" -> {
                contacts.get(index).setName();
            }
            case "surname" -> {
                contacts.get(index).setSurname();
            }
            case "birth" -> {
                contacts.get(index).setBirthDate();
            }
            case "gender" -> {
                contacts.get(index).setGender();
            }
            case "address" -> {
                contacts.get(index).setAddress();
            }
            case "number" -> {
                contacts.get(index).setPhoneNumber();
            }
            default -> throw new IllegalArgumentException("No such field exists!\n\n");
        }
        contacts.get(index).setTimeLastEdit(LocalDateTime.now());
        phoneBook.saveContacts(fileName);
        ConsoleHelper.writeMessage("Saved\n");
        ConsoleHelper.writeMessage(contacts.get(index).showInfo());
    }
}
