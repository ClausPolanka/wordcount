package com.wordcount.reader;

import java.util.List;

public interface StopwordReader {

    /**
     * Reads a resource file called stopwords.txt and returns a list of stopwords.
     * If the file is not present, will return an emtpy list
     */
    List<String> readStopwords();

}
