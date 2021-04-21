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
    public void printStats(WordsStats wordsStats) {
        printWordsCount(wordsStats.getWordCount());
        printUniqueWordsCount(wordsStats.getUniqueWordCount());
    }

    private void printWordsCount(int wordCount) {
        this.outputStream.println("Number of words: " + wordCount);
    }

    private void printUniqueWordsCount(int wordCount) {
        this.outputStream.println("unique: " + wordCount);
    }


}
