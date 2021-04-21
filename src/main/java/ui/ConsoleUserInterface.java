package ui;

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
    public void printWordsCount(int wordCount) {
        this.outputStream.println("Number of words: " + wordCount);
    }


}
