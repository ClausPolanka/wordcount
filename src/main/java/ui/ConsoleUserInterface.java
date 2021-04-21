package ui;

import stats.WordsStats;

import java.io.InputStream;
import java.io.PrintStream;

public class ConsoleUserInterface implements UserInterface {

    private PrintStream outputStream;

    public ConsoleUserInterface(PrintStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public InputStream getUserInput() {
        return System.in;
    }

    @Override
    public void askForInput() {
        this.outputStream.print("Enter text: ");
    }

    @Override
    public void printStats(WordsStats wordsStats) {
        this.outputStream.println(wordsStats);
    }

}
