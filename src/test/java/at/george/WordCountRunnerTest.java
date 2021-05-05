package at.george;

import at.george.counter.StopwordsFilterDecorator;
import at.george.counter.TextSequenceCounter;
import at.george.io.ConsoleReader;
import at.george.io.FileReader;
import at.george.io.ResourceBasedStopwordsProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountRunnerTest {

    private final WordCountRunner wordCountRunner = new WordCountRunner();

    @Test
    public void testUserSample() {
        WordCountConfiguration configuration = new WordCountConfiguration(
                new FixedInputReader("Mary had a little lamb"),
                new TextSequenceCounter(),
                count -> assertEquals(5, count)
        );

        wordCountRunner.run(configuration);
    }

    @Test
    public void testUserSampleFromFile() {
        WordCountConfiguration configuration = new WordCountConfiguration(
                new FileReader(new String[]{"mytext.txt"}, new ConsoleReader()),
                new TextSequenceCounter(),
                count -> assertEquals(5, count)
        );

        wordCountRunner.run(configuration);
    }

    @Test
    public void testUserSampleWithStopwords() {
        WordCountConfiguration configuration = new WordCountConfiguration(
                new FixedInputReader("Mary had a little lamb"),
                new StopwordsFilterDecorator(new TextSequenceCounter(), new ResourceBasedStopwordsProvider()),
                count -> assertEquals(4, count)
        );

        wordCountRunner.run(configuration);
    }

    @Test
    public void testUserSampleFromFileWithStopwords() {
        WordCountConfiguration configuration = new WordCountConfiguration(
                new FileReader(new String[]{"mytext.txt"}, new ConsoleReader()),
                new StopwordsFilterDecorator(new TextSequenceCounter(), new ResourceBasedStopwordsProvider()),
                count -> assertEquals(4, count)
        );

        wordCountRunner.run(configuration);
    }

    @Test
    public void testSingleWord() {
        WordCountConfiguration configuration = new WordCountConfiguration(
                new FixedInputReader("word"),
                new TextSequenceCounter(),
                count -> assertEquals(1, count)
        );

        wordCountRunner.run(configuration);
    }

    @Test
    public void testMultipleWords() {
        WordCountConfiguration configuration = new WordCountConfiguration(
                new FixedInputReader("word word"),
                new TextSequenceCounter(),
                count -> assertEquals(2, count)
        );

        wordCountRunner.run(configuration);

        configuration = new WordCountConfiguration(
                new FixedInputReader("word word word"),
                new TextSequenceCounter(),
                count -> assertEquals(3, count)
        );

        wordCountRunner.run(configuration);
    }

    @Test
    public void testEmptyInput() {
        WordCountConfiguration configuration = new WordCountConfiguration(
                new FixedInputReader(""),
                new TextSequenceCounter(),
                count -> assertEquals(0, count)
        );

        wordCountRunner.run(configuration);
    }
}
