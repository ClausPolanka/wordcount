import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import root.wordcounter.WordCounter;
import root.infrastructure.FileStopWordsProvider;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @Test
    public void okCorrectCountSingleWord() {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        assertEquals(1, wordCounter.countWords("Test"));
    }

    @Test
    public void okCorrectCountMultipleWords() {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        assertEquals(2, wordCounter.countWords("Test     test"));
    }

    @Test
    public void okCorrectCountMultipleWordsIncludingInvalidWord() {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        assertEquals(1, wordCounter.countWords("Test test2"));
    }

    @Test
    public void okCorrectCountMultipleWordsIncludingStopword() {
        WordCounter wordCounter = new WordCounter(new HashSet<>(Collections.singletonList("stopword")));
        assertEquals(1, wordCounter.countWords("Test stopword"));
    }


    @Test
    public void okCorrectCountEmptyText() {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        assertEquals(0, wordCounter.countWords(""));
    }

}
