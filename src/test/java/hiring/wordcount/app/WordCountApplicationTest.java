package hiring.wordcount.app;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WordCountApplicationTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void iOException() {
        assertThrows(IOException.class, () -> {
            FileInputStream inputStream =
                    new FileInputStream(getClass().getClassLoader().getResource("stopwords.txt").getFile());
            inputStream.close();

            System.setIn(inputStream);

            String[] args = new String[]{};

            WordCountApplication.main(args);
        });
    }

    @Test
    public void integrationTestForEmptyInput() {
        // for getting the standard io input
        System.setIn(new ByteArrayInputStream("\n".getBytes(StandardCharsets.UTF_8)));
        System.setOut(new PrintStream(outContent));
        String[] args = new String[]{};

        assertDoesNotThrow(() -> WordCountApplication.main(args));

        assertTrue(outContent.toString().contains("0"));

    }

    @Test
    public void integrationTestForNotEmptyInput() {
        // for getting the standard io input
        System.setIn(new ByteArrayInputStream("test test test".getBytes(StandardCharsets.UTF_8)));
        System.setOut(new PrintStream(outContent));
        String[] args = new String[]{};

        assertDoesNotThrow(() -> WordCountApplication.main(args));

        assertTrue(outContent.toString().contains("3"));
    }
}