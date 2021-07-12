import com.wordcount.ProcessDataImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProcessDataImplTest {
    ProcessDataImpl processData;

    @BeforeEach
    public void init() {
        processData = new ProcessDataImpl();
    }

    @Test
    public void processUserInputTest() {
        String input = "Welcome to George Test";
        Assertions.assertEquals(4, processData.processUserInput(input).size());
    }

    @Test
    public void given_stopWords_processUserInputTest() {
        String input = "Welcome to George off Test";
        Assertions.assertEquals(4, processData.processUserInput(input).size());
        Assertions.assertFalse(processData.processUserInput(input).contains("off"));

    }

    @Test
    public void given_UpperCase_stopWords_processUserInputTest() {
        String input = "Welcome to George Off Test";
        Assertions.assertEquals(5, processData.processUserInput(input).size());
        Assertions.assertTrue(processData.processUserInput(input).contains("Welcome"));
        Assertions.assertTrue(processData.processUserInput(input).contains("Off"));
    }

}
