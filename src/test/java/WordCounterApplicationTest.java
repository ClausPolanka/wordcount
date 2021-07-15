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
        Assertions.assertEquals("Number of words: 6", result);
    }

}