package wordcount;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MainTest {

    public static final String USER_INPUT_MESSAGE = "Mary had a little lamb";
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @AfterEach
    void tearDown() throws IOException {
        outputStreamCaptor.close();
    }

    @Test
    void should_Count_Words_From_User_Input() {
        System.setIn(new ByteArrayInputStream(USER_INPUT_MESSAGE.getBytes()));

        Main.main();

        assertEquals("Number of words: 5", outputStreamCaptor.toString());
    }
}