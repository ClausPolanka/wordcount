import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import root.wordcounter.CountingResult;
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
        assertEquals(new CountingResult(1,1), wordCounter.countWords("Test"));
    }

    @Test
    public void okCorrectCountWordsSeperatedByStroke() {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        assertEquals(new CountingResult(2,1), wordCounter.countWords("Test-Test"));
    }

    @Test
    public void okCorrectCountWordWithPointAtTheEnd() {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        assertEquals(new CountingResult(1,1), wordCounter.countWords("Test."));
    }

    @Test
    public void okCorrectCountWordsWithPointAtTheEnd() {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        assertEquals(new CountingResult(2,2), wordCounter.countWords("Test. Test"));
    }

    @Test
    public void okCorrectCountWordWithPointInTheMiddle() {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        assertEquals(new CountingResult(0,0), wordCounter.countWords("Test.t"));
    }

    @Test
    public void okCorrectCountMultipleWords() {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        assertEquals(new CountingResult(2,1), wordCounter.countWords("Test     Test"));
    }

    @Test
    public void okCorrectCountMultipleWordsIncludingInvalidWord() {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        assertEquals(new CountingResult(1,1), wordCounter.countWords("Test test2"));
    }

    @Test
    public void okCorrectCountMultipleWordsIncludingStopword() {
        WordCounter wordCounter = new WordCounter(new HashSet<>(Collections.singletonList("stopword")));
        assertEquals(new CountingResult(1,1), wordCounter.countWords("Test stopword"));
    }


    @Test
    public void okCorrectCountEmptyText() {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        assertEquals(new CountingResult(0,0), wordCounter.countWords(""));
    }

}
