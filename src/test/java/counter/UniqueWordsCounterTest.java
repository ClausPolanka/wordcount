package counter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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

        final Map<String, Integer> uniqueWords = uniqueWordsCounter.countUniqueWords("Humpty-Dumpty sat on a wall. wall wall wall");
        assertFalse(uniqueWords.isEmpty());
        assertEquals(6, uniqueWords.size());

        assertEquals(4, uniqueWords.get("wall"));
        assertEquals(1, uniqueWords.get("sat"));
    }

}