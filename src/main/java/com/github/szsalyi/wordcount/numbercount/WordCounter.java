package com.github.szsalyi.wordcount.numbercount;

import java.util.List;

public class WordCounter {
    private WordCheck wordCheck;

    public WordCounter() {
        this.wordCheck = new WordCheck(new StopWords());
    }

    public long count(List<String> words) {
        if (words == null) return 0L;

        return words.stream()
                .filter(w -> wordCheck.isValid(w))
                .count();
    }
}
