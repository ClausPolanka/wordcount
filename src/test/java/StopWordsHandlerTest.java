import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StopWordsHandlerTest {

    private StopWordsHandler stopWordsHandler = new StopWordsHandler();

    @Test
    public void test_validStopWord_the(){
        boolean isStopWord = stopWordsHandler.isStopword("the");
        assertTrue(isStopWord);
    }

    @Test
    public void test_validStopWord_a(){
        boolean isStopWord = stopWordsHandler.isStopword("a");
        assertTrue(isStopWord);
    }

    @Test
    public void test_validStopWord_on(){
        boolean isStopWord = stopWordsHandler.isStopword("on");
        assertTrue(isStopWord);
    }

    @Test
    public void test_validStopWord_off(){
        boolean isStopWord = stopWordsHandler.isStopword("off");
        assertTrue(isStopWord);
    }

    @Test
    public void test_not_validStopWord_Mary(){
        boolean isStopWord = stopWordsHandler.isStopword("Mary");
        assertFalse(isStopWord);
    }
}
