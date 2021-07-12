import com.wordcount.InputUserImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputUserImplTest {

    InputUserImpl  inputUser;

    @BeforeEach
    public void setUp()  {
        inputUser = new InputUserImpl();
    }

    @Test
    public void getUserInputTest() {
        String input = " Welcome to George Test";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Assertions.assertEquals(input,inputUser.getUserInput());
    }
}