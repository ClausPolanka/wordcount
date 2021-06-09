package root.service.impl;

import root.service.OutputInterface;
import root.service.WordInputInterface;

import java.util.Scanner;

public class ConsoleWordInput implements WordInputInterface {

    private final Scanner scanner = new Scanner(System.in);
    private final OutputInterface output;

    public ConsoleWordInput(OutputInterface output) {
        this.output = output;
    }

    @Override
    public String getInput() {
        this.output.print("Enter text: ");
        if(scanner.hasNextLine()) {
            return scanner.nextLine();
        }
        return null;
    }
}
