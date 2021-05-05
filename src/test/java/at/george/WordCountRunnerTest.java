package at.george;

import org.junit.jupiter.api.Test;

public class WordCountRunnerTest {

    private final WordCountRunner wordCountRunner = new WordCountRunner();

    @Test
    public void testUserSample() {
        WordCountConfiguration configuration = new WordCountConfiguration(
                new FixedInputReader("Mary had a little lamb"),
                new TextSequenceCounter(),
                new CountAsserter(5)
        );

        wordCountRunner.run(configuration);
    }

    @Test
    public void testSingleWord() {
        WordCountConfiguration configuration = new WordCountConfiguration(
                new FixedInputReader("word"),
                new TextSequenceCounter(),
                new CountAsserter(1)
        );

        wordCountRunner.run(configuration);
    }

    @Test
    public void testMultipleWords() {
        WordCountConfiguration configuration = new WordCountConfiguration(
                new FixedInputReader("word word"),
                new TextSequenceCounter(),
                new CountAsserter(2)
        );

        wordCountRunner.run(configuration);

        configuration = new WordCountConfiguration(
                new FixedInputReader("word word word"),
                new TextSequenceCounter(),
                new CountAsserter(3)
        );

        wordCountRunner.run(configuration);
    }

    @Test
    public void testEmptyInput() {
        WordCountConfiguration configuration = new WordCountConfiguration(
                new FixedInputReader(""),
                new TextSequenceCounter(),
                new CountAsserter(0)
        );

        wordCountRunner.run(configuration);
    }
}
