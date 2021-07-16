package com.wordcount;

import java.util.*;

public class ProcessDataImpl {
    private static final String DELIMITER = "\\s+";
    private static final String PATH_STOP_WORD = "src/resources/stopwords.txt";


    public List<String> processUserInput(String input) {
        StopWordArchive stopWordArchive = new StopWordArchive();
        List<String> wordList = new ArrayList<>();
        List<String> validWordList = new ArrayList<>();
        Set<String> excludeWordList = stopWordArchive.getAllWords(PATH_STOP_WORD);

        if (input != null) {
            String[] words = input.split(DELIMITER);
            Collections.addAll(wordList, words);
            for (String word : wordList) {
                if (!word.isEmpty()
                        && word.chars().allMatch(Character::isLetter)
                        &&!excludeWordList.contains(word)) {
                    validWordList.add(word);
                }
            }
        }
        return validWordList;
    }
}
