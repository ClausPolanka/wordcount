import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import root.service.WordCounterInterface;
import root.service.impl.DefaultWordCounter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {

    @ParameterizedTest
    @CsvSource(value = {"Mary had a little lamb;5",
            "Mary had a little lamb4;4",
            "Mary     had    a little lamb4;4",
            ";0"}, delimiter = ';')
    public void okCorrectCounts(String input, int expected) {
        WordCounterInterface wordCounter = new DefaultWordCounter();

        assertEquals(expected, wordCounter.countWords(input));
    }

    @Test
    public void okCorrectCountEmptyText() {
        WordCounterInterface wordCounter = new DefaultWordCounter();
        assertEquals(0, wordCounter.countWords(""));
    }

}
