package wordcounter.userinterface;

import org.junit.jupiter.api.Test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class UserInterfaceTest {

    @Test
    void shouldConvertMyTextInputToString() {
        UserInterface userInterface = new UserInterface(new ByteArrayInputStream("this is my input".getBytes(StandardCharsets.UTF_8)), new ByteArrayOutputStream());
        assertEquals("this is my input", userInterface.getInput());
    }

    @Test
    void shouldHaveNumberOfWordsOnOutput() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        UserInterface userInterface = new UserInterface(new ByteArrayInputStream("this is my input".getBytes(StandardCharsets.UTF_8)), outputStream);
        userInterface.showOutput(4);
        assertEquals("Number of words: 4", outputStream.toString());
    }
}