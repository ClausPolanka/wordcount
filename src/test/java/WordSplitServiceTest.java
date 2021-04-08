import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordSplitServiceTest {

    WordSplitService wordSplitService = new WordSplitService();

    @Test
    public void testSplit_wordSequence(){
        String toTest = "Mary had a little lamb";
        List<String> splittedWords = wordSplitService.splitWordsFromString(toTest);

        assertEquals("Mary", splittedWords.get(0));
        assertEquals("had", splittedWords.get(1));
        assertEquals("a", splittedWords.get(2));
        assertEquals("little", splittedWords.get(3));
        assertEquals("lamb", splittedWords.get(4));
    }

    @Test
    public void testSplit_emptyString(){
        String toTest = "";
        List<String> splittedWords = wordSplitService.splitWordsFromString(toTest);

        assertTrue(splittedWords == null);
    }

    @Test
    public void testSplit_emptyStringWithSpace(){
        String toTest = " ";
        List<String> splittedWords = wordSplitService.splitWordsFromString(toTest);

        assertTrue(splittedWords == null);
    }

    @Test
    public void testSplit_emptyStringWithComma(){
        String toTest = " , ";
        List<String> splittedWords = wordSplitService.splitWordsFromString(toTest);

        assertTrue(splittedWords == null);
    }
}
