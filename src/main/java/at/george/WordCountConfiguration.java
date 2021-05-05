package at.george;

public class WordCountConfiguration {

    private final Reader reader;

    private final Processor processor;

    private final Writer writer;

    public WordCountConfiguration(Reader reader, Processor processor, Writer writer) {
        this.reader = reader;
        this.processor = processor;
        this.writer = writer;
    }

    public Reader reader() {
        return reader;
    }

    public Processor processor() {
        return processor;
    }

    public Writer writer() {
        return writer;
    }
}
