package at.george;

import org.junit.jupiter.api.Test;

public class SpecialCharactersTests {

    private final WordCountRunner wordCountRunner = new WordCountRunner();

    @Test
    public void testMultipleWordsWithSpaces() {
        WordCountConfiguration configuration = new WordCountConfiguration(
                new FixedInputReader("word  word                                    word                                word"),
                new TextSequenceCounter(),
                new CountAsserter(4)
        );

        wordCountRunner.run(configuration);
    }

    @Test
    public void testSingleWordWithSpecialCharactersInBetween() {
        WordCountConfiguration configuration = new WordCountConfiguration(
                new FixedInputReader("wo3d"),
                new TextSequenceCounter(),
                new CountAsserter(0)
        );

        wordCountRunner.run(configuration);
    }

    @Test
    public void testMultipleWordsWithSpecialCharactersInBetween() {
        WordCountConfiguration configuration = new WordCountConfiguration(
                new FixedInputReader("word wo$rd"),
                new TextSequenceCounter(),
                new CountAsserter(1)
        );

        wordCountRunner.run(configuration);
    }

    @Test
    public void testMultipleWordsWithSpecialCharactersAtTheEnd() {
        WordCountConfiguration configuration = new WordCountConfiguration(
                new FixedInputReader("word, word. word? word"),
                new TextSequenceCounter(),
                new CountAsserter(1)
        );

        wordCountRunner.run(configuration);
    }
}
