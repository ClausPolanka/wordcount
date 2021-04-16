package com.github.szsalyi.wordcount.numbercount;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class StopWords {
    public Set<String> loadStopWords() {
        String path = "C:\\GIT_PROJECTS\\wordcount\\src\\main\\resources\\stopword.txt";
        Set<String> stopWords = new HashSet<>();
        String line;

        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            while ((line = bf.readLine()) != null) {
                stopWords.add(line);
            }
        } catch (IOException fileNotFoundException) {
            throw new RuntimeException("IOException occurred while reading stop words.", fileNotFoundException);
        }

        return stopWords;
    }

}
