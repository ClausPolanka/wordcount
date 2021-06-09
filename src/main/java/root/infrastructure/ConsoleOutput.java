package root.infrastructure;

import root.wordcounter.OutputInterface;

public class ConsoleOutput implements OutputInterface {

    @Override
    public void print(String text) {
        System.out.print(text);
    }
}
