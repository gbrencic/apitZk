package hr.zk.common.util.input;

import java.io.IOException;

/**
 * User: gbrencic
 * Date: 01.10.13.
 * Time: 15:31
 */
public class ConsoleEcho {
    public static void main(String[] args) throws IOException {
        final InputReader consoleInput = new ConsoleInput();
        String input = "";
        boolean read = true;

        while (read) {
            input = consoleInput.readInput();
            writeOutInput(input);
            read = checkExit(input, read);
        }
    }

    private static void writeOutInput(String input) {
        System.out.println("Echo: " + input);
    }

    private static boolean checkExit(String input, boolean read) {
        if (input.toUpperCase().equals("exit"))
            read = false;
        return read;
    }
}
