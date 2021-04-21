import counter.UniqueWordsCounter;
import counter.WordCounter;
import filters.StopWordsFilter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stats.WordsStats;
import stopwords.StopWordsLoader;
import ui.ConsoleUserInterface;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class E2ETest {

    private final PrintStream originalOut = System.out;
    private ConsoleUserInterface consoleUserInterface;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        consoleUserInterface = new ConsoleUserInterface(printStream);
    }

    @AfterEach
    void afterEach() {
        System.setOut(originalOut);
    }

    @Test
    public void test() {
        final StopWordsLoader stopWordsFileLoader = new MyStopWords();
        final StopWordsFilter stopWordsFilter = new StopWordsFilter(stopWordsFileLoader.loadStopWords());
        final WordCounter wordCounter = new WordCounter();
        final UniqueWordsCounter uniqueWordsCounter = new UniqueWordsCounter();

        final String rawSentence = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        final String stopWordsFilteredSentence = stopWordsFilter.filter(rawSentence);

        consoleUserInterface.printStats(
                new WordsStats(wordCounter.countWords(stopWordsFilteredSentence),
                        uniqueWordsCounter.countUniqueWords(stopWordsFilteredSentence)
                ));
        assertEquals("Number of words: 10, unique: 8", outContent.toString());
    }

    private static class MyStopWords implements StopWordsLoader {

        @Override
        public Set<String> loadStopWords() {
            Set<String> set = new HashSet<>();
            set.add("the");
            set.add("a");

            return set;
        }
    }

}