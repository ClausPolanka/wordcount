package chrapusta.tomasz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordCounterTest {
    @ParameterizedTest
    @CsvSource({
            "@!@, word, 1",
            "@!@, w, 1",
            "@!@, word word, 2",
            "@!@, word the word a           wo3d, 2",
            "@!@, word; word. word?, 0",
            "@!@, word word wo$d, 2",
            "@!@, ' ', 0",
            "@!@, word word the a on off, 2",
            "@!@, word word the aa on off, 3",
    })
    public void wordCountIsRight(final String separator, final String inputStr, final long countExpected) {
        //GIVEN
        Set<String> stopWords = getStopWords();
        WordCounter sut = new WordCounter(separator, stopWords);
        //WHEN
        long countWords = sut.countWords(inputStr);
        //THEN
        Assertions.assertEquals(countWords, countExpected);
    }

    private Set<String> getStopWords() {
        return new HashSet<>(Arrays.asList("the", "a", "on", "off"));
    }

    @Test()
    public void throwsExceptionForNullString() {
        WordCounter sut = new WordCounter("@!@", null);

        assertThrows(IllegalArgumentException.class, () -> sut.countWords(null));
    }
}
