import org.junit.jupiter.api.Test;
import services.StopWordsHandlerService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StopWordsHandlerServiceTest {

    private StopWordsHandlerService stopWordsHandlerService = new StopWordsHandlerService();

    @Test
    public void test_validStopWord_the(){
        boolean isStopWord = stopWordsHandlerService.isStopword("the");
        assertTrue(isStopWord);
    }

    @Test
    public void test_validStopWord_a(){
        boolean isStopWord = stopWordsHandlerService.isStopword("a");
        assertTrue(isStopWord);
    }

    @Test
    public void test_validStopWord_on(){
        boolean isStopWord = stopWordsHandlerService.isStopword("on");
        assertTrue(isStopWord);
    }

    @Test
    public void test_validStopWord_off(){
        boolean isStopWord = stopWordsHandlerService.isStopword("off");
        assertTrue(isStopWord);
    }

    @Test
    public void test_not_validStopWord_Mary(){
        boolean isStopWord = stopWordsHandlerService.isStopword("Mary");
        assertFalse(isStopWord);
    }
}
