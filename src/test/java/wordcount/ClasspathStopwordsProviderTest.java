package wordcount;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}