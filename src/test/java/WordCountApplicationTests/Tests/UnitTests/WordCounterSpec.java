package WordCountApplicationTests.Tests.UnitTests;

import WordCountApplication.Controller.Interfaces.View;
import WordCountApplication.Controller.WordCounter;
import WordCountApplicationTests.TestHelper.MockIoWorker;
import WordCountApplication.View.WordCounterConsoleView;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterSpec {
    private View view = new WordCounterConsoleView();
    private MockIoWorker mockWorker = new MockIoWorker();
    private WordCounter wordCounter = new WordCounter(view, mockWorker);

    @Test
    void canCountWordsWithOutForbiddenCharacters() {
        // given
        mockWorker.setMockInput(new ArrayList<String>(){ { add("Test text without forbidden word"); } });

        // when
        wordCounter.countWords();

        // then
        assertEquals(5, wordCounter.listOfWords.size());
    }

    @Test
    void canCountWordsWithForbiddenCharacters() {
        // given
        mockWorker.setMockInput(new ArrayList<String>(){ { add("Te*st text with! forbi123dden word"); } });

        // when
        wordCounter.countWords();

        // then
        assertEquals(2, wordCounter.listOfWords.size());
    }

    @Test
    void canCountWordsWithStopWords() {
        // given
        mockWorker.setMockInput(new ArrayList<String>(){ { add("test text with! mock forbi123dden word"); } });

        // when
        wordCounter.countWords();

        // then
        assertEquals(2, wordCounter.listOfWords.size());
    }
}
