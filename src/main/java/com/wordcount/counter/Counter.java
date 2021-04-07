package com.wordcount.counter;

import java.util.Arrays;

public class Counter {

    public long countWords(String words) {
        String[] splittedString = words.split(" ");
        return Arrays.stream(splittedString)
                .filter(s -> !s.isEmpty())
                .filter(this::containsOnlyLetters).count();
    }

    private boolean containsOnlyLetters(String word) {
        return word.chars().allMatch(Character::isLetter);
    }

}
