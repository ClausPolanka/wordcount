package com.github.szsalyi.numbercount;

import com.github.szsalyi.wordcount.numbercount.StopWords;

import java.util.Set;

/**
 * @author Szabolcs Salyi
 * @since 2021-04-16
 */
public class MockStopWords extends StopWords {
    private Set<String> testSet;

    public MockStopWords(Set<String> pTestSet) {
        testSet = pTestSet;
    }

    @Override
    public Set<String> loadStopWords() {
        return this.testSet;
    }
}
