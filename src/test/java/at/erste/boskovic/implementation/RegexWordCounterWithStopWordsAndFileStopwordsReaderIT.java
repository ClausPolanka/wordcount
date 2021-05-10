package at.erste.boskovic.implementation;

import at.erste.boskovic.StopWordsReader;
import at.erste.boskovic.WordCounter;
import at.erste.boskovic.stopwordsreaders.FileStopWordReader;
import at.erste.boskovic.stopwordsreaders.FileStopWordReaderTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegexWordCounterWithStopWordsAndFileStopwordsReaderIT {


    @Test
    void shouldCountCorrectWithoutStopwords(){
        test("word word word", 3);
    }

    @Test
    void shouldCountCorrectWithStopwords(){
        test("word test_off word test_on word", 3);
    }

    private void test(String sentence, long expectedCount){
        StopWordsReader reader = new FileStopWordReader(FileStopWordReaderTest.STOPWORDS_TEST_FILE);
        WordCounter wordCounter = new RegexWordCounter(reader.readStopwords());
        assertEquals(expectedCount, wordCounter.countWords(sentence));
    }
}
