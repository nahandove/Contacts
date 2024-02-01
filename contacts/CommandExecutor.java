package contacts;

import contacts.command.*;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static final Map<Operation, Command> allCommandsMap = new HashMap<>();
    static {
        allCommandsMap.put(Operation.ADD, new AddCommand());
        allCommandsMap.put(Operation.LIST, new ListCommand());
        allCommandsMap.put(Operation.SEARCH, new SearchCommand());
        allCommandsMap.put(Operation.EDIT, new EditCommand());
        allCommandsMap.put(Operation.REMOVE, new RemoveCommand());
        allCommandsMap.put(Operation.COUNT, new CountCommand());
        allCommandsMap.put(Operation.INFO, new InfoCommand());
        allCommandsMap.put(Operation.EXIT, new ExitCommand());
    }

    private CommandExecutor() {

    }

    public static void execute(Operation operation) {
        allCommandsMap.get(operation).execute();
    }
}
