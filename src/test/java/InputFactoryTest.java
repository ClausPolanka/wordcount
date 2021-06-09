import mocks.MockOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import root.service.InputFactory;
import root.service.WordInputInterface;
import root.service.impl.ConsoleWordInput;
import root.service.impl.FileWordInput;
import root.service.impl.InvalidUserInputException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputFactoryTest {

    @Test
    public void okCreateInputNoArgs() throws InvalidUserInputException {
        InputFactory factory = new InputFactory(new MockOutput());

        assertEquals(factory.createInput(new String[]{}).getClass(), ConsoleWordInput.class);
    }

    @Test
    public void okCreateInputNullArgs() throws InvalidUserInputException {
        InputFactory factory = new InputFactory(new MockOutput());

        assertEquals(factory.createInput(null).getClass(), ConsoleWordInput.class);
    }

    @Test
    public void okCreateInputArgs() throws InvalidUserInputException {
        InputFactory factory = new InputFactory(new MockOutput());

        assertEquals(factory.createInput(new String[]{"src/main/resources/mytext.txt"}).getClass(), FileWordInput.class);
    }

    @Test
    public void okCreateInvalidInputArgs() throws InvalidUserInputException {
        MockOutput output = new MockOutput();
        InputFactory factory = new InputFactory(new MockOutput());
        factory.createInput(new String[]{"invalidFile.txt"});
        
    }

}
