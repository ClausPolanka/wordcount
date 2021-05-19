package wordcounter.userinterface;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class UserInterfaceHandlerFromSysInTest {

    @Test
    void shouldConvertMyTextInputToString() {
        UserInterfaceHandlerConsole userInterfaceHandlerConsole = new UserInterfaceHandlerConsole(new ByteArrayInputStream("this is my input".getBytes(StandardCharsets.UTF_8)), new ByteArrayOutputStream());
        assertEquals("this is my input", userInterfaceHandlerConsole.getInput());
    }

    @Test
    void shouldHaveNumberOfWordsOnOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        UserInterfaceHandlerConsole userInterfaceHandlerConsole = new UserInterfaceHandlerConsole(new ByteArrayInputStream("this is my input".getBytes(StandardCharsets.UTF_8)), outputStream);
        userInterfaceHandlerConsole.showOutput(4);
        assertEquals("Number of words: 4", outputStream.toString());
    }
}