package wordcounter.reader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileReaderTest {

    @Test
    void shouldReadStopWords() {
        FileReader fileReader = new FileReader("stopwords.txt");
        assertEquals(Stream.of("the", "a", "on", "off").collect(Collectors.toList()), fileReader.getContent());
    }

    @Test
    void shouldThrowExceptionWhenFileNotFound() {
        assertThrows(IllegalArgumentException.class, () -> new FileReader("nosuchfile.txt"));
    }

}
