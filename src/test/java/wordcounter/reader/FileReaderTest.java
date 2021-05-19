package wordcounter.reader;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileReaderTest {

    @Test
    void shouldReadStopWords() {
        FileReader fileReader = new FileReader();
        assertEquals(Stream.of("the", "a", "on", "off").collect(Collectors.toList()), fileReader.getContent());
    }

}
