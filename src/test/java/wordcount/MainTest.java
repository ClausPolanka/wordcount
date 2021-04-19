package wordcount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void readFileTest() {
        final IWordCounter wordCounter = new WordCounterImpl();
        final String inputText = "Mary had\n" +
                "a little\n" +
                "lamb\n";
        assertEquals(wordCounter.count(inputText), 2);
    }
}
