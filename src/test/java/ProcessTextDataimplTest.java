import com.wordcount.ProcessTextDataImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProcessTextDataimplTest {

    ProcessTextDataImpl processData;

    @BeforeEach
    public void init() {
        processData = new ProcessTextDataImpl();
    }

    @Test
    public void givenNoTextFile_processUserInputTest() {
        String input = "Welcome to George Test";
        Assertions.assertEquals(0, processData.processUserInput(input).size());
    }

    @Test
    public void given_FileName_processUserInputTest() {
        String input = "mytext.txt";
        List<String> output = processData.processUserInput(input);
        Assertions.assertEquals(4, output.size());
        Assertions.assertTrue(output.contains("Mary"));
        Assertions.assertFalse(output.contains("a"));
    }

    @Test
    public void given_WrongFile_s_processUserInputTest() {
        String input = "text.txt";
        Assertions.assertEquals(0, processData.processUserInput(input).size());
    }
}
