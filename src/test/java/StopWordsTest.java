import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StopWordsTest {

    @Test
    public void whenAskingForStopWords_shouldReturnTheLinesAsStringArray() {
        //given

        //when
        String[] stopWords = new StopWords().stopWordsAsList();

        //then
        Assertions.assertEquals(4, stopWords.length);
    }
}