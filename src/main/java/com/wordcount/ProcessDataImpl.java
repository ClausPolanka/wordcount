package com.wordcount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProcessDataImpl {
    private static final String DELIMITER = "\\s+";

    public List<String> processUserInput(String input) {

        List<String> wordList = new ArrayList<>();
        List<String> validWordList = new ArrayList<>();
        if (input != null) {
            String[] words = input.split(DELIMITER);
            Collections.addAll(wordList, words);
            for (String word : wordList) {
                if (!word.isEmpty()
                        && word.chars().allMatch(Character::isLetter)) {
                    validWordList.add(word);
                }
            }
        }
        return validWordList;
    }


}
