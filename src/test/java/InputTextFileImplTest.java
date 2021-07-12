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
}
