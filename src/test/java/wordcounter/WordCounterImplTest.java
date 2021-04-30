package wordcounter;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordCounterImplTest {

    @Test
    public void whenWordsFromInput_thenReturnWordsNumberFirstExample() {
        List<String> words = WordCounterUtils.retrieveWordsFromUserInput("Mary had a little lamb");
        WordCounter wordCounter = new WordCounterImpl(words);

        assertEquals(4, wordCounter.computeTotalWordsNumber());
        assertEquals(4, wordCounter.computeUniqueWordsNumber());
        assertEquals(4.25, wordCounter.computeWordLengthAverage());
        assertTrue(wordCounter.retrieveWordsSorted().containsAll(Arrays.asList("Mary", "had", "little", "lamb")));
    }

    @Test
    public void whenWordsFromInput_thenReturnWordsNumberSecondExample() {
        List<String> words = WordCounterUtils.retrieveWordsFromUserInput("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall");
        WordCounter wordCounter = new WordCounterImpl(words);

        assertEquals(7, wordCounter.computeTotalWordsNumber());
        assertEquals(6, wordCounter.computeUniqueWordsNumber());
        assertEquals(6.43, wordCounter.computeWordLengthAverage());
        assertTrue(wordCounter.retrieveWordsSorted().containsAll(Arrays.asList("Humpty-Dumpty", "sat", "wall", "had", "great", "fall")));
    }

    @Test
    public void whenWordsFromExternalResource_thenReturnWordsNumber() {
        List<String> words = WordCounterUtils.retrieveWordsFromResource("mytext.txt");
        WordCounter wordCounter = new WordCounterImpl(words);

        assertEquals(4, wordCounter.computeTotalWordsNumber());
        assertEquals(4, wordCounter.computeUniqueWordsNumber());
        assertEquals(4.25, wordCounter.computeWordLengthAverage());
        assertTrue(wordCounter.retrieveWordsSorted().containsAll(Arrays.asList("Mary", "had", "little", "lamb")));
    }
}
