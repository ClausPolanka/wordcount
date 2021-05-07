package wordcount;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClasspathStopwordsProviderTest {
    @Test
    void getStopWords() {
        ClasspathStopwordsProvider provider = new ClasspathStopwordsProvider("stopwords.txt");

        Set<String> stopWords = provider.getStopWords();

        Set<String> expected = new HashSet<>();
        expected.add("the");
        expected.add("a");
        expected.add("on");
        expected.add("off");

        assertEquals(expected, stopWords);
    }

    @Test
    void getStopWords_nonExistingFile() {

        String exceptionMessage = assertThrows(IllegalArgumentException.class, () -> new ClasspathStopwordsProvider("some_bla_this_is_not_there.txt").getStopWords())
                .getMessage();

        assertTrue(exceptionMessage.contains("Cannot find the file specified"));

    }
}