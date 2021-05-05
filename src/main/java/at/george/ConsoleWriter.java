package at.george;

public class ConsoleWriter implements Writer {

    /**
     * Writes the count to the console
     *
     * @param count The count to be written to the console, must not be negative
     */
    @Override
    public void write(long count) {
        System.out.println("Number of words: " + count);
    }
}
