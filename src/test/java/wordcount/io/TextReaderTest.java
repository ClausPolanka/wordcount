package wordcount.io;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class TextReaderTest {

    @Test
    void readText() {
        InputStreamReader is = new InputStreamReader( new ByteArrayInputStream("Hello World".getBytes(StandardCharsets.UTF_8)));

        ITextReader textReader = new TextReader(is);

       assertEquals( "Hello World", textReader.readText());


    }
}
