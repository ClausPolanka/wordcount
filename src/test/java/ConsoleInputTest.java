import mocks.MockOutput;
import org.junit.jupiter.api.Test;
import root.wordcounter.InputInterface;
import root.infrastructure.ConsoleInput;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleInputTest {

    @Test
    public void okIntroTextPrinted() {
        InputStream mockInput = new ByteArrayInputStream("Marry ".getBytes());
        InputStream backUpSystemIn = System.in;
        System.setIn(mockInput);
        MockOutput output = new MockOutput();
        InputInterface input = new ConsoleInput(output);

        String text = input.getInput();

        assertEquals("Enter text: ", output.getText());
        assertEquals("Marry ", text);

        System.setIn(backUpSystemIn);
    }

    @Test
    public void okNoInputProvided() {
        InputStream mockInput = new ByteArrayInputStream(new byte[0]);
        InputStream backUpSystemIn = System.in;
        System.setIn(mockInput);
        MockOutput output = new MockOutput();
        InputInterface input = new ConsoleInput(output);

        String text = input.getInput();

        assertEquals("Enter text: ", output.getText());
        assertEquals("", text);

        System.setIn(backUpSystemIn);
    }

}
