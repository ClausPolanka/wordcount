package com.github.szsalyi.wordcount.numbercount;


import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCheck {

    private String validRegex = "[a-zA-Z]+";
    private Pattern pattern;
    private StopWords stopWordsInput;

    public WordCheck(StopWords stopWords) {
        this.stopWordsInput = stopWords;
        pattern = Pattern.compile(validRegex);
    }

    public boolean isValid(String word) {
        if (word == null) return false;

        Set<String> stopWords = stopWordsInput.loadStopWords();
        if (stopWords.contains(word)) return false;

        Matcher matcher = pattern.matcher(word);

        return matcher.matches();
    }
}
