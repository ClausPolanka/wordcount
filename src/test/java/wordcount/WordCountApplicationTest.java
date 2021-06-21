package wordcount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class WordCountApplicationTest {
    private ByteArrayOutputStream byteArrayOutputStream;
    private PrintStream console;
    @BeforeEach
    public void setup() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        console = System.out;
    }

    @Test
    void appTestFromConsoleShouldComputeWordsCorrectly()  {

        final InputStream input = new ByteArrayInputStream("asd".getBytes(StandardCharsets.UTF_8));
        final InputStream old = System.in;

        try {

            System.setOut(new PrintStream(byteArrayOutputStream));
            System.setIn(input);
            WordCountApplication.main();

        } catch(Exception ex) {
            System.setOut(console);
            System.setIn(old);
        }

    }

    @Test
    void appTestFromFileShouldComputeWordsCorrectly()  {
        WordCountApplication.main("mytext.txt");
    }

}
