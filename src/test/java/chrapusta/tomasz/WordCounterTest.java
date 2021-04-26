package chrapusta.tomasz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WordCounterTest {
    @ParameterizedTest
    @CsvSource({
            "@!@, word, 1",
            "@!@, w, 1",
            "@!@, word word, 2",
            "@!@, word word            wo3d, 2",
            "@!@, word; word. word?, 0",
            "@!@, word word wo$d, 2",
            "@!@, ' ', 0",
    })
    public void wordCountIsRight(final String separator, final String inputStr, final long countExpected) {
        //GIVEN
        WordCounter sut = new WordCounter(separator);
        //WHEN
        long countWords = sut.countWords(inputStr);
        //THEN
        Assertions.assertEquals(countWords, countExpected);
    }
}
