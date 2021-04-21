package counter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniqueWordsCounterTest {

    private UniqueWordsCounter uniqueWordsCounter;

    @BeforeEach
    public void beforeEach() {
        uniqueWordsCounter = new UniqueWordsCounter();
    }

    @Test
    public void whenSentenceIsNullThenNoUniqueWords() {
        assertTrue(uniqueWordsCounter.countUniqueWords(null).isEmpty());
    }

    @Test
    public void whenSentenceIsEmptyThenNoUniqueWords() {
        assertTrue(uniqueWordsCounter.countUniqueWords("").isEmpty());
        assertTrue(uniqueWordsCounter.countUniqueWords("    ").isEmpty());
    }

}