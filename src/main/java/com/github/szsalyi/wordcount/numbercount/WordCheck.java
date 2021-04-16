package com.github.szsalyi.wordcount.numbercount;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCheck {

    private String validRegex = "[a-zA-Z]+";
    private Pattern pattern;

    public WordCheck() {
       pattern = Pattern.compile(validRegex);
    }

    public boolean isValid(String word) {
        if (word == null) return false;

        Matcher matcher = pattern.matcher(word);

        return matcher.matches();
    }
}
