package com.ableneo.erste.wordcount.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class StopWordsFilter {

    private final List<String> stopWords;

    public StopWordsFilter(String stopWordsFile) {
        try {
            this.stopWords = readStopWordsFromResourceFile(stopWordsFile);
        } catch (IOException e) {
            throw new IllegalStateException("Stop words filter couldn't be initialized");
        }
    }

    public boolean isStopWord(String word) {
        return stopWords.contains(word);
    }

    private List<String> readStopWordsFromResourceFile(String uri) throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream(uri);
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        List<String> stopWords = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null;) {
            stopWords.add(line);
        }

        reader.close();
        return stopWords;
    }
}
