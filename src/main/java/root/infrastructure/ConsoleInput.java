package root.infrastructure;

import root.wordcounter.OutputInterface;
import root.wordcounter.InputInterface;

import java.util.Scanner;

public class ConsoleInput implements InputInterface {

    private final Scanner scanner = new Scanner(System.in);
    private final OutputInterface output;

    public ConsoleInput(OutputInterface output) {
        this.output = output;
    }

    @Override
    public String getInput() {
        this.output.print("Enter text: ");
        if(scanner.hasNextLine()) { //if not input is provided
            return scanner.nextLine();
        }
        return "";
    }
}
