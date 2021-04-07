package com.wordcount.filter;

import com.wordcount.reader.StopwordReader;

import java.util.List;
import java.util.stream.Collectors;

public class StopwordFilterImpl implements StopwordFilter {

    private StopwordReader reader;

    public StopwordFilterImpl(StopwordReader reader) {
        this.reader = reader;
    }

    public List<String> removeStopwords(List<String> words) {
        List<String> stopwords = reader.readStopwords();
        return words.stream()
                .filter(word -> !stopwords.contains(word))
                .collect(Collectors.toList());
    }

}
