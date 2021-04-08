import exceptions.FilenameNotProvidedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import unit.WordFileReader;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordFileReaderTest {

    private WordFileReader reader = new WordFileReader();

    @Test
    public void test_loadOfMissingFile_null_FileParameter() {
        Assertions.assertThrows(FilenameNotProvidedException.class, () -> {
            reader.loadWords(null);
        });
    }

    @Test
    public void test_loadOfMissingFile_empty_FileParameter(){
        Assertions.assertThrows(FilenameNotProvidedException.class, () -> {
            reader.loadWords("");
        });
    }

    @Test
    public void test_loadFile_mytext_test() throws FilenameNotProvidedException {
        List<String> words = reader.loadWords("mytext_test.txt");

        assertNotNull(words);
        assertTrue(words.size() > 0);

        assertEquals("Mary", words.get(0));
        assertEquals("had", words.get(1));
        assertEquals("a", words.get(2));
        assertEquals("little", words.get(3));
        assertEquals("lamb", words.get(4));

    }

    @Test
    public void test_loadFile_empty_test() throws FilenameNotProvidedException {
        List<String> words = reader.loadWords("empty_test.txt");

        assertNotNull(words);
        assertEquals(0, words.size());

    }
}
