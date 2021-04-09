package integration;

import controller.WordCountController;
import org.junit.jupiter.api.Test;
import service.WordCountService;
import testUtil.MockIO;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountControllerTest {

    @Test
    public void test_countWords(){

        final MockIO io = new MockIO();
        final WordCountService service = new WordCountService();
        final WordCountController controller = new WordCountController(io, service);

        io.setInputString("ABC");

        assertEquals("Number of words: 1", controller.countWords());

        io.setInputString("ABC .DEF");

        assertEquals("Number of words: 1", controller.countWords());

        io.setInputString("AB1C .DEF");

        assertEquals("Number of words: 0", controller.countWords());

        io.setInputString("AB1C def");

        assertEquals("Number of words: 1", controller.countWords());

    }

}
