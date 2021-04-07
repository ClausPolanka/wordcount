package com.wordcount.counter;

import com.wordcount.reader.StopwordReader;

import java.util.List;
import java.util.stream.Collectors;

public class StopwordFilter {

    private StopwordReader reader = new StopwordReader();

    public void setReader(StopwordReader reader) {
        this.reader = reader;
    }

    public List<String> removeStopwords(List<String> words) {
        List<String> stopwords = reader.readStopwords();
        return words.stream()
                .filter(word -> !stopwords.contains(word))
                .collect(Collectors.toList());
    }

}
