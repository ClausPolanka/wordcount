package counter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniqueWordsCounterTest {

    private UniqueWordsCounter uniqueWordsCounter;

    @BeforeEach
    public void beforeEach() {
        uniqueWordsCounter = new UniqueWordsCounter();
    }

    @Test
    public void whenSentenceIsNullThenNoUniqueWords() {
        assertEquals(0, uniqueWordsCounter.countUniqueWords(null));
    }

    @Test
    public void whenSentenceIsEmptyThenNoUniqueWords() {
        assertEquals(0, uniqueWordsCounter.countUniqueWords(""));
        assertEquals(0, uniqueWordsCounter.countUniqueWords("    "));

        final int uniqueWordsCount = uniqueWordsCounter.countUniqueWords("Humpty-Dumpty sat on a wall. wall wall wall");
        assertEquals(6, uniqueWordsCount);
    }

}