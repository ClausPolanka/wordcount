import mocks.MockOutput;
import org.junit.jupiter.api.Test;
import root.wordcounter.InputFactory;
import root.infrastructure.ConsoleInput;
import root.infrastructure.FileInput;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputFactoryTest {

    @Test
    public void okCreateInputNoArgs() {
        InputFactory factory = new InputFactory(new MockOutput());

        assertEquals(factory.createInput(new String[]{}).getClass(), ConsoleInput.class);
    }

    @Test
    public void okCreateInputNullArgs() {
        InputFactory factory = new InputFactory(new MockOutput());

        assertEquals(factory.createInput(null).getClass(), ConsoleInput.class);
    }

    @Test
    public void okCreateInputArgs() {
        InputFactory factory = new InputFactory(new MockOutput());

        assertEquals(factory.createInput(new String[]{"src/main/resources/mytext.txt"}).getClass(), FileInput.class);
    }

    @Test
    public void okCreateInvalidInputArgs() {
        MockOutput output = new MockOutput();
        InputFactory factory = new InputFactory(new MockOutput());
        factory.createInput(new String[]{"invalidFile.txt"});

    }

}
