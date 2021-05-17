package wordcount;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MainTest {

    public static final String USER_INPUT_MESSAGE = "Mary had a little lamb";
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @AfterEach
    void tearDown() throws IOException {
        outputStreamCaptor.close();
    }

    @Test
    void should_Main_Interact_With_User() {
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setIn(new ByteArrayInputStream(USER_INPUT_MESSAGE.getBytes()));

        Main.main();

        assertEquals("Enter text: Number of words: 4", outputStreamCaptor.toString());
    }

    @Test
    void should_Main_Interact_With_User_With_Provided_File() {
        System.setOut(new PrintStream(outputStreamCaptor));
        System.setIn(new ByteArrayInputStream(USER_INPUT_MESSAGE.getBytes()));

        Main.main("words_to_count.txt");

        assertEquals("Number of words: 6", outputStreamCaptor.toString());
    }
}