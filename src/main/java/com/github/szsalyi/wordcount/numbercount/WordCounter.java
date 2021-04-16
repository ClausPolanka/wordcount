package com.github.szsalyi.wordcount.numbercount;

import java.util.List;

public class WordCounter {
    private WordCheck wordCheck;

    public WordCounter() {
        this.wordCheck = new WordCheck();
    }

    public long count(List<String> words) {
        return words.stream()
                .filter(w -> wordCheck.isValid(w))
                .count();
    }
}
