package at.george;

public class WordCountRunner {

    public void run(WordCountConfiguration configuration) {
        Reader reader = configuration.reader();
        Processor processor = configuration.processor();
        Writer writer = configuration.writer();

        String line = reader.read();

        long count = processor.process(line);

        writer.write(count);
    }
}
