package at.george;

public class ConsoleWriter implements Writer {
    @Override
    public void write(long count) {
        System.out.println("Number of words: " + count);
    }
}
