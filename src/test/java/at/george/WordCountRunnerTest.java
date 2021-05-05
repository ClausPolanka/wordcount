package at.george;

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
    public void testUserSampleWithStopwords() {
        WordCountConfiguration configuration = new WordCountConfiguration(
                new FixedInputReader("Mary had a little lamb"),
                new StopwordsFilterDecorator(new TextSequenceCounter()),
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
