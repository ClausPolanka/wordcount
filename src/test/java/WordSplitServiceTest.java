import exceptions.NotValidWordStringException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.WordSplitService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordSplitServiceTest {

    WordSplitService wordSplitService = new WordSplitService();

    @Test
    public void testSplit_wordSequence() throws NotValidWordStringException {
        String toTest = "Mary had a little lamb";
        List<String> splittedWords = wordSplitService.splitWordsFromString(toTest);

        assertEquals("Mary", splittedWords.get(0));
        assertEquals("had", splittedWords.get(1));
        assertEquals("a", splittedWords.get(2));
        assertEquals("little", splittedWords.get(3));
        assertEquals("lamb", splittedWords.get(4));
    }

    @Test
    public void testSplit_emptyString() {
        String toTest = "";
        Assertions.assertThrows(NotValidWordStringException.class, () -> {
            wordSplitService.splitWordsFromString(toTest);
        });
    }

    @Test
    public void testSplit_emptyStringWithSpace() {
        String toTest = " ";
        Assertions.assertThrows(NotValidWordStringException.class, () -> {
            wordSplitService.splitWordsFromString(toTest);
        });
    }

    @Test
    public void testSplit_emptyStringWithComma() {
        String toTest = " , ";
        Assertions.assertThrows(NotValidWordStringException.class, () -> {
            wordSplitService.splitWordsFromString(toTest);
        });
    }
}
