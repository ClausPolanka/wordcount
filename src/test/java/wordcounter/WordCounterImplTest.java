package wordcounter;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterImplTest {

    @Test
    public void whenWordsFromInput_thenReturnWordsNumberFirstExample() {
        List<String> words = WordCounterUtils.retrieveWordsFromUserInput("Mary had a little lamb");
        WordCounter wordCounter = new WordCounterImpl(words);

        assertEquals(4, wordCounter.computeTotalWordsNumber());
        assertEquals(4, wordCounter.computeUniqueWordsNumber());
    }

    @Test
    public void whenWordsFromInput_thenReturnWordsNumberSecondExample() {
        List<String> words = WordCounterUtils.retrieveWordsFromUserInput("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall");
        WordCounter wordCounter = new WordCounterImpl(words);

        assertEquals(9, wordCounter.computeTotalWordsNumber());
        assertEquals(7, wordCounter.computeUniqueWordsNumber());
    }

    @Test
    public void whenWordsFromExternalResource_thenReturnWordsNumber() {
        List<String> words = WordCounterUtils.retrieveWordsFromResource("mytext.txt");
        WordCounter wordCounter = new WordCounterImpl(words);

        assertEquals(4, wordCounter.computeTotalWordsNumber());
        assertEquals(4, wordCounter.computeUniqueWordsNumber());
    }
}
