package wordcount.io;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StopWordReaderTest {


    @Test
    void shouldReturnCorrectListOfStopwords() {
       StopWordReader stopWordReader = new StopWordReader();
        var expected = List.of("the", "a", "on", "off");
       assertArrayEquals(expected.toArray(),  stopWordReader.readStopWords().toArray());
    }

}
