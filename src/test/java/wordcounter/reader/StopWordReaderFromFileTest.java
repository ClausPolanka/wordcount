package wordcounter.reader;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StopWordReaderFromFileTest {

    @Test
    void shouldReadStopWords() {
        StopWordReaderFromFile stopWordReaderFromFile = new StopWordReaderFromFile("stopwords.txt");
        assertEquals(Stream.of("the", "a", "on", "off").collect(Collectors.toList()), stopWordReaderFromFile.getStopWords());
    }

    @Test
    void shouldThrowExceptionWhenFileNotFound() {
        assertThrows(IllegalArgumentException.class, () -> new StopWordReaderFromFile("nosuchfile.txt"));
    }

}
