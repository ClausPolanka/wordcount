package filereader;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileReaderTest {

    @Test
    public void whenLoadValidPath_thenReturnContentList() {
        List<String> stopwords = FileReader.readLines("stopwords.txt");

        assertEquals(4, stopwords.size());
    }

    @Test
    public void whenLoadInvalidPath_thenReturnEmptyList() {
        List<String> stopwords = FileReader.readLines("stopwords_invalid.txt");

        assertEquals(0, stopwords.size());
    }
}
