import mocks.MockOutput;
import org.junit.jupiter.api.Test;
import root.service.WordInputInterface;
import root.service.impl.ConsoleWordInput;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleInputTest {

    @Test
    public void okIntroTextPrinted() {
        InputStream mockInput = new ByteArrayInputStream("Marry ".getBytes());
        InputStream backUpSystemIn = System.in;
        System.setIn(mockInput);
        MockOutput output = new MockOutput();
        WordInputInterface input = new ConsoleWordInput(output);

        String text = input.getInput();

        assertEquals("Enter text: ", output.getText());
        assertEquals("Marry ", text);

        System.setIn(backUpSystemIn);
    }

}
