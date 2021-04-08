import entities.WordCountResult;
import org.junit.jupiter.api.Test;
import services.WordCountService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountServiceTest {

    private WordCountService wordCountService = new WordCountService();

    @Test
    public void countWords_test1() {
        List<String> words = Arrays.asList("Mary", "had", "a", "little", "lamb");
        WordCountResult result = wordCountService.count(words);
        assertEquals(4, result.getAmountCountableWords());
        assertEquals(4, result.getAmountUniqueWords());
    }

    @Test
    public void countWords_test2() {
        List<String> words = Arrays.asList("Mary", "had", "another", "very","little", "lamb");
        WordCountResult result = wordCountService.count(words);
        assertEquals(6, result.getAmountCountableWords());
        assertEquals(6, result.getAmountUniqueWords());
    }

    @Test
    public void countWords_emptyString() {
        List<String> words = Arrays.asList("");
        WordCountResult result = wordCountService.count(words);
        assertEquals(0, result.getAmountCountableWords());
        assertEquals(0, result.getAmountUniqueWords());
    }

    @Test
    public void countWords_emptyString_withSingleSpace() {
        List<String> words = Arrays.asList(" ");
        WordCountResult result = wordCountService.count(words);
        assertEquals(0, result.getAmountCountableWords());
        assertEquals(0, result.getAmountUniqueWords());
    }

    @Test
    public void countWords_singleWord() {
        List<String> words = Arrays.asList("Hello");
        WordCountResult result = wordCountService.count(words);
        assertEquals(1, result.getAmountCountableWords());
        assertEquals(1, result.getAmountUniqueWords());
    }

    @Test
    public void countWords_onlyStopWords() {
        List<String> words = Arrays.asList("the", "a", "on", "off");
        WordCountResult result = wordCountService.count(words);
        assertEquals(0, result.getAmountCountableWords());
        assertEquals(0, result.getAmountUniqueWords());
    }

    @Test
    public void countWords_mixtureBetween_stopwords_and_nonStopwords() {
        List<String> words = Arrays.asList("the", "Mary", "a", "little", "lamb", "on", "her", "last", "trip", "off", "wool");
        WordCountResult result = wordCountService.count(words);
        assertEquals(7, result.getAmountCountableWords());
        assertEquals(7, result.getAmountUniqueWords());
    }

    @Test
    public void countWords_differentAmountWords_between_countableAndUniqueWords() {
        List<String> words = Arrays.asList("Humpty-Dumpty", "sat", "on", "a", "wall", "Humpty-Dumpty", "had", "a", "great", "fall");
        WordCountResult result = wordCountService.count(words);
        assertEquals(7, result.getAmountCountableWords());
        assertEquals(6, result.getAmountUniqueWords());
    }

    @Test
    public void countWords_alwaysSameWord() {
        List<String> words = Arrays.asList("Humpty", "Humpty", "Humpty", "Humpty", "Humpty");
        WordCountResult result = wordCountService.count(words);
        assertEquals(5, result.getAmountCountableWords());
        assertEquals(1, result.getAmountUniqueWords());
    }

    @Test
    public void countWords_alwaysSameWord_withHyphen() {
        List<String> words = Arrays.asList("Humpty-Dumpty", "Humpty-Dumpty", "Humpty-Dumpty", "Humpty-Dumpty", "Humpty-Dumpty");
        WordCountResult result = wordCountService.count(words);
        assertEquals(5, result.getAmountCountableWords());
        assertEquals(1, result.getAmountUniqueWords());
    }

    @Test
    public void countWords_alwaysSameWord_withAndWithoutHyphen() {
        List<String> words = Arrays.asList("Humpty-Dumpty", "Humpty", "Dumpty", "Humpty-Dumpty", "Humpty", "Dumpty", "Humpty-Dumpty");
        WordCountResult result = wordCountService.count(words);
        assertEquals(7, result.getAmountCountableWords());
        assertEquals(3, result.getAmountUniqueWords());
    }
}
