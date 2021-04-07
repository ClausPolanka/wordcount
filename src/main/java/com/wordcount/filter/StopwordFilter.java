package com.wordcount.filter;

import java.util.List;

public interface StopwordFilter {

    /**
     * Removes the stopwords from the provided list and returns it as a new list.
     */
    List<String> removeStopwords(List<String> words);

}
