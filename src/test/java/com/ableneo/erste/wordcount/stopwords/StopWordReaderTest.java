package com.ableneo.erste.wordcount.stopwords;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StopWordReaderTest {
    private StopWordReader reader = new StopWordReader();

    @Test
    void read() throws IOException {
        List<String> stopWords = reader.readFromResourceFile("stopwords.txt");
        assertEquals(4, stopWords.size());
    }
}
