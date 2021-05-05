package at.george;

public class WordCountConfiguration {

    private final Reader reader;

    private final Counter counter;

    private final Writer writer;

    public WordCountConfiguration(Reader reader, Counter counter, Writer writer) {
        this.reader = reader;
        this.counter = counter;
        this.writer = writer;
    }

    public Reader reader() {
        return reader;
    }

    public Counter counter() {
        return counter;
    }

    public Writer writer() {
        return writer;
    }
}
