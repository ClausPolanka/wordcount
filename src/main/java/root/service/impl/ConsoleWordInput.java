package root.service.impl;

import root.service.WordInputInterface;

import java.util.Scanner;

public class ConsoleWordInput implements WordInputInterface {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getInput() {
        if(scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return null;
    }
}
