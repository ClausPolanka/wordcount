package wordcount.io;

import org.junit.jupiter.api.Test;
import wordcount.utils.ResourceFetcher;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StopwordReaderTest {


    @Test
    void shouldReturnCorrectListOfStopwords() {
        var resourceFetcher = new ResourceFetcher();
       StopwordReader stopwordReader = new StopwordReader(resourceFetcher);
        var expected = List.of("the", "a", "on", "off");
       assertArrayEquals(expected.toArray(),  stopwordReader.readStopwords().toArray());
    }

}
