package wordcounter;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WordCounterApplicationTest {

    @Test
    void shouldInputTextAndCountWordsInIt() {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("this is my input".getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream byteArrayOutput = new ByteArrayOutputStream();
        PrintStream outputStream = new PrintStream(byteArrayOutput);
        System.setIn(inputStream);
        System.setOut(outputStream);
        WordCounterApplication.main(new String[0]);
        assertTrue(byteArrayOutput.toString().contains("Number of words: 4"));
    }
}