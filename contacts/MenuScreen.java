package contacts;

public class MenuScreen {
    static PhoneBook phoneBook = PhoneBook.getInstance();
    public static void start() {
        Operation operation = null;
        do {
            try {
                operation = mainMenu();
                CommandExecutor.execute(operation);
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage(e.getMessage());
            }
        } while (operation != Operation.EXIT);
    }

    public static Operation mainMenu() {
        ConsoleHelper.writeMessage("[menu] Enter action (add, list, search, count, exit): ");
        String command = ConsoleHelper.readString();
        return switch (command) {
            case "add" -> Operation.ADD;
            case "list" -> Operation.LIST;
            case "search" -> Operation.SEARCH;
            case "count" -> Operation.COUNT;
            case "exit" -> Operation.EXIT;
            default -> throw new IllegalArgumentException("No such action exists.\n");
        };
    }

    public static Operation searchMenu() {
        ConsoleHelper.writeMessage("[search] Enter action ([number], back, again): ");
        String command = ConsoleHelper.readString();
        phoneBook.setIndex(Integer.parseInt(command));
        if (!"back".equals(command)) {
            if (command.matches("[1-9]+[0-9]*")) {
                return Operation.INFO;
            } else {
                if ("again".equals(command)) {
                    return Operation.SEARCH;
                } else {
                    throw new IllegalArgumentException("Unknown action.\n");
                }
            }
        }
        return null;
    }

    public static Operation listMenu() {
        ConsoleHelper.writeMessage("[list] Enter action ([number], back): ");
        String command = ConsoleHelper.readString();
        phoneBook.setIndex(Integer.parseInt(command));
        if ("back".equals(command)) {
            ConsoleHelper.writeMessage("\n");
        } else {
            if (command.matches("[1-9]+[0-9]*")) {
                return Operation.INFO;
            } else {
                throw new IllegalArgumentException("Unknown action.");
            }
        }
        return null;
    }

    public static Operation recordMenu() {
        ConsoleHelper.writeMessage("[record] Enter action (edit, delete, menu): ");
        String command = ConsoleHelper.readString();
        if ("menu".equals(command)) {
            ConsoleHelper.writeMessage("\n");
        } else {
            if ("edit".equals(command)) {
                return Operation.EDIT;
            }
            if ("delete".equals(command)) {
                return Operation.REMOVE;
            }
            throw new IllegalArgumentException("Unknown action.\n");
        }
        return null;
    }
}
