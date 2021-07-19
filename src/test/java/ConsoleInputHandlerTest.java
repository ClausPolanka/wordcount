import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class ConsoleInputHandlerTest {

    @Test
    public void givenInputStream_returnTextFromConsole() {
        // given
        String text = "Mary is a little girl, something else. The guys are playing outside, but I'm not.";
        InputStream in = new ByteArrayInputStream(text.getBytes());

        // when
        ConsoleInputHandler consoleInputHandler = new ConsoleInputHandler(in);
        String readText = consoleInputHandler.getInputText();

        //then
        Assertions.assertEquals(text, readText);
    }

}