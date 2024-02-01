package contacts;

import java.util.Scanner;

public class ConsoleHelper {
    static Scanner scanner = new Scanner(System.in);
    public static void writeMessage(String message) {
        System.out.print(message);
    }
    public static String readString() {
        return scanner.nextLine();
    }
}
