package com.github.szsalyi.wordcount.io;

import com.github.szsalyi.wordcount.numbercount.WordCheck;

/**
 * @author Szabolcs Salyi
 * @since 2021-04-16
 */
public class WordCheckTest extends WordCheck {
    @Override
    public boolean isValid(String word) {
        return true;
    }
}
