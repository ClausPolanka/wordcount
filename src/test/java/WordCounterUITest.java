import mocks.MockOutput;
import mocks.StringInput;
import org.junit.jupiter.api.Test;
import root.service.impl.DefaultWordCounter;
import root.service.impl.FileStopWordsProvider;
import root.ui.WordCounterUIInterface;
import root.ui.impl.WordCounterUI;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterUITest {

    @Test
    public void okTestCorrectCounts() {
        MockOutput output = new MockOutput();
        StringInput input = new StringInput("Mary had a little lamb");
        WordCounterUIInterface ui = new WordCounterUI(input, output, new DefaultWordCounter(new FileStopWordsProvider()));

        ui.countWords();

        assertEquals("Enter text: Number of words: 4", output.getText());
    }

}
