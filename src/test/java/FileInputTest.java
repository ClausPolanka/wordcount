import mocks.MockOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import root.service.WordInputInterface;
import root.service.impl.ConsoleWordInput;
import root.service.impl.FileWordInput;
import root.service.impl.InvalidUserInputException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileInputTest {

    @Test
    public void okReadFile() throws InvalidUserInputException {
        WordInputInterface input = new FileWordInput("src/main/resources/mytext.txt");

        String text = input.getInput();

        assertEquals("Mary had\n" + "a little\n" + "lamb", text);

    }

    @Test
    public void nokReadInvalidFile() throws InvalidUserInputException {

        Assertions.assertThrows(InvalidUserInputException.class, () -> {
            WordInputInterface input = new FileWordInput("invalidFile.txt");
        });


    }

}
