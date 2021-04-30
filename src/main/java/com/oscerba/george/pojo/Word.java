package com.oscerba.george.pojo;

import java.util.Objects;

public class Word {
    private final String word;
    private final boolean presentInDict;

    public Word(String word, boolean presentInDict) {
        this.word = word;
        this.presentInDict = presentInDict;
    }

    public String getWord() {
        return word;
    }

    public boolean isPresentInDict() {
        return presentInDict;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return presentInDict == word1.presentInDict && Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, presentInDict);
    }
}
