package at.george;

public class WordCountRunner {

    public void run(WordCountConfiguration configuration) {
        Reader reader = configuration.reader();
        Counter counter = configuration.counter();
        Writer writer = configuration.writer();

        String userInput = reader.read();

        long count = counter.count(userInput);

        writer.write(count);
    }
}
