package com.ableneo.erste.wordcount.stopwords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads stop words
 */
public class StopWordReader {

    /**
     * Reads from resource file
     * @param uri resource file URI
     * @return list of stop words
     */
    public List<String> readFromResourceFile(String uri) throws IOException {
        InputStream is = getClass().getClassLoader().getResourceAsStream(uri);
        InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(streamReader);

        List<String> stopWords = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null;) {
            stopWords.add(line);
        }

        return stopWords;
    }
}
