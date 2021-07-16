import com.wordcount.InputTextFileImpl;
import com.wordcount.InputUserImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputTextFileImplTest {

    InputTextFileImpl textFile;

    @BeforeEach
    public void setUp() {
        textFile = new InputTextFileImpl();
    }

    @Test
    public void getUserInputTest() {
        String input = "mytext.txt";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertNotNull(textFile.getUserInput());
    }
    @Test
    public void getUserInputTest2() {
        String input = "mytext.txt";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertTrue(textFile.getUserInput().contains(input));
    }

    @Test
    public void getUserInputTest3() {
        String input = "mytext.txt";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertTrue(textFile.getUserInput().contains(input));
    }

    @Test
    public void givenWrongFile_getUserInputTest() {
        String input = "text.txt";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertNull(textFile.getUserInput());
    }
    @Test
    public void given_No_File_getUserInputTest() {
        String input = " ";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertNull(textFile.getUserInput());
    }
}
