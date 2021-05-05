package at.george;

import java.util.Scanner;

public class ConsoleReader implements Reader {

    @Override
    public String read() {
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }
}
