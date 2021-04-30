package com.oscerba.george.parser;

import java.util.Arrays;
import java.util.List;

public class WordParser {

    public List<String> getWords(String words){
        return Arrays.asList(words.split("\\s+"));
    }
}
