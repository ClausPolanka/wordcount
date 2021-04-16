package com.github.szsalyi.wordcount.numbercount;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCheck {

    private String validRegex = "[a-zA-Z]+";

    public boolean isValid(String word) {
        Pattern pattern = Pattern.compile(validRegex);
        Matcher matcher = pattern.matcher(word);

        return matcher.matches();
    }
}
