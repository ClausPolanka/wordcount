package wordcount.io;

import org.junit.jupiter.api.Test;
import utils.ResourceFetcher;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StopWordReaderTest {


    @Test
    void shouldReturnCorrectListOfStopwords() {
        var resourceFetcher = new ResourceFetcher();
       StopWordReader stopwordReader = new StopWordReader(resourceFetcher);
        var expected = List.of("the", "a", "on", "off");
       assertArrayEquals(expected.toArray(),  stopwordReader.readStopWords().toArray());
    }

}
