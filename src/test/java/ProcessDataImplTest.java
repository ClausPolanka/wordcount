import com.wordcount.ProcessDataImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProcessDataImplTest {
    ProcessDataImpl processData ;

    @BeforeEach
    public void init()  {
        processData = new ProcessDataImpl();
    }
    @Test
    public void processUserInput()  {
        String input = "Welcome to George Test";
        Assertions.assertEquals(4, processData.processUserInput(input).size());
    }

}
