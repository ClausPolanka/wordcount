package com.wordcount.filter;

import java.util.List;

public class StopwordFilterMockImpl implements StopwordFilter {

    public List<String> removeStopwords(List<String> words) {
        return words;
    }

}
