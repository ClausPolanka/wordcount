package at.george.io;

import at.george.Reader;

import java.util.Scanner;

public class ConsoleReader implements Reader {

    /**
     * Reads an input string from the console
     *
     * @return The received input
     */
    @Override
    public String read() {
        System.out.print("Enter text: ");

        String userInput;
        try (Scanner scanner = new Scanner(System.in)) {
            userInput = scanner.nextLine();
        }

        return userInput;
    }
}
