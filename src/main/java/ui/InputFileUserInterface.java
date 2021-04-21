package ui;

import stats.WordsStats;

import java.io.*;
import java.net.URL;

public class InputFileUserInterface implements UserInterface {

    private final PrintStream outputStream;
    private final String filename;

    public InputFileUserInterface(PrintStream outputStream, String filename) {
        this.outputStream = outputStream;
        this.filename = filename;
    }

    @Override
    public InputStream getUserInput() {
        final ClassLoader classLoader = getClass().getClassLoader();
        final URL stopWordsFileResource = classLoader.getResource(this.filename);
        if (stopWordsFileResource == null) {
            // log that something went wrong
            return System.in;
        }
        final File stopWordsFile = new File(stopWordsFileResource.getFile());
        try {
            return new FileInputStream(stopWordsFile);
        } catch (FileNotFoundException e) {
            // log a message here
            return System.in;
        }
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
