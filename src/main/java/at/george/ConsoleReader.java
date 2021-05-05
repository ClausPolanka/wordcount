package at.george;

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
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
}
