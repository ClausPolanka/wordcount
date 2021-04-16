package com.github.szsalyi.wordcount.numbercount;

import java.util.Set;

/**
 * @author Szabolcs Salyi
 * @since 2021-04-16
 */
public class WordCheckImpl implements WordCheck {

    private Set<Character> validChars;

    public WordCheckImpl(Set<Character> validChars) {
        this.validChars = validChars;
    }

    @Override
    public boolean isValid(String word) {
        
        return false;
    }
}
