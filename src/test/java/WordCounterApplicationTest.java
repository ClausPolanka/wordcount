import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordCounterApplicationTest {

    @Test
    public void testWordCounterFromFileInput() {
        //given
        String fileName = "/tmp/text.txt";

        //when
        WordCounterApplication wordCounter = new WordCounterApplication(new String[]{fileName});
        String result = wordCounter.countWordsFromInput();

        //then
        Assertions.assertEquals("Number of words: 6, unique: 6, average word length: 4,17", result);
    }

    @Test
    public void testWordCounterFromFileInputWith12Words() {
        //given
        String fileName = "/tmp/text-2.txt";

        //when
        WordCounterApplication wordCounter = new WordCounterApplication(new String[]{fileName});
        String result = wordCounter.countWordsFromInput();

        //then
        Assertions.assertEquals("Number of words: 12, unique: 10, average word length: 4,25", result);
    }

    @Test
    public void testWordCounterFromFileInputWith12WordsReturnsTheAverageLengthToo() {
        //given
        String fileName = "/tmp/text-2.txt";

        //when
        WordCounterApplication wordCounter = new WordCounterApplication(new String[]{fileName});
        String result = wordCounter.countWordsFromInput();

        //then
        Assertions.assertEquals("Number of words: 12, unique: 10, average word length: 4,25", result);
    }

}