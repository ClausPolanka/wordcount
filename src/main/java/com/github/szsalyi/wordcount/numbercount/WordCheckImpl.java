package com.github.szsalyi.wordcount.numbercount;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Szabolcs Salyi
 * @since 2021-04-16
 */
public class WordCheckImpl implements WordCheck {

    private String validRegex;

    public WordCheckImpl(String validRegex) {
        this.validRegex = validRegex;
    }

    @Override
    public boolean isValid(String word) {
        Pattern pattern = Pattern.compile(validRegex);
        Matcher matcher = pattern.matcher(word);

        return matcher.matches();
    }
}
