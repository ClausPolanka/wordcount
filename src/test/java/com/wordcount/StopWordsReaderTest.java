package com.wordcount;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StopWordsReaderTest {

    @Test
    public void stopWordsReaderCanLoadAllWordsFromFile() {
        Set<String> expectedWords = new HashSet<>(Arrays.asList("the", "a", "on", "off"));

        StopWordsReader stopWordsReader = new StopWordsReader();
        assertEquals(expectedWords, stopWordsReader.readStopWords());
    }
}