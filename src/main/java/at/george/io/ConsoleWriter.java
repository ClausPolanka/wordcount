package at.george.io;

import at.george.Writer;

public class ConsoleWriter implements Writer {

    /**
     * Writes the count and the unique count to the console
     *
     * @param count       The count to be written to the console, must not be negative
     * @param uniqueCount The count of unique words to be written to the console, must not be negative
     */
    @Override
    public void write(long count, long uniqueCount) {
        System.out.println("Number of words: " + count + ", unique: " + uniqueCount);
    }
}
