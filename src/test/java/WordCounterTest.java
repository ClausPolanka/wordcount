import org.junit.jupiter.api.Test;
import root.wordcounter.data.CountingResult;
import root.wordcounter.WordCounter;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @Test
    public void okCorrectCountSingleWord() {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        assertEquals(new CountingResult(1,1, 4, Collections.singletonList("Test")),
                wordCounter.countWords("Test"));
    }

    @Test
    public void okCorrectCountWordContainingByStroke() {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        assertEquals(new CountingResult(1,1, 9, Collections.singletonList("Test-Test")),
                wordCounter.countWords("Test-Test"));
    }

    @Test
    public void okCorrectCountInvalidWordEndingWithHyphen() {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        assertEquals(new CountingResult(0,0, 0, Collections.emptyList()),
                wordCounter.countWords("Test-"));
    }

    @Test
    public void okCorrectCountWordWithPointAtTheEnd() {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        assertEquals(new CountingResult(1,1, 5, Collections.singletonList("Test.")),
                wordCounter.countWords("Test."));
    }

    @Test
    public void okCorrectCountWordsWithPointAtTheEnd() {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        assertEquals(new CountingResult(2,2, 4.5, Arrays.asList("Test", "Test.")),
                wordCounter.countWords("Test. Test"));
    }

    @Test
    public void okCorrectCountWordWithPointInTheMiddle() {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        assertEquals(new CountingResult(0,0,0, Collections.emptyList()),
                wordCounter.countWords("Test.t"));
    }

    @Test
    public void okCorrectCountMultipleWords() {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        assertEquals(new CountingResult(2,1, 4, Collections.singletonList("Test")),
                wordCounter.countWords("Test     Test"));
    }

    @Test
    public void okCorrectCountMultipleWordsIncludingInvalidWord() {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        assertEquals(new CountingResult(1,1, 4, Collections.singletonList("Test")),
                wordCounter.countWords("Test test2"));
    }

    @Test
    public void okCorrectCountMultipleWordsIncludingStopword() {
        WordCounter wordCounter = new WordCounter(new HashSet<>(Collections.singletonList("stopword")));
        assertEquals(new CountingResult(1,1, 4, Collections.singletonList("Test")),
                wordCounter.countWords("Test stopword"));
    }


    @Test
    public void okCorrectCountEmptyText() {
        WordCounter wordCounter = new WordCounter(new HashSet<>());
        assertEquals(new CountingResult(0,0, 0, Collections.emptyList()),
                wordCounter.countWords(""));
    }

}
