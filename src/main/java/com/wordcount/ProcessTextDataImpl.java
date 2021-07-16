package com.wordcount;

import java.util.*;

public class ProcessTextDataImpl implements ProcessData {
    private static final String PATH_STOP_WORD = "src/resources/stopwords.txt";
    public static final String ROOT_PATH = "src/resources/";


    @Override
    public List<String> processUserInput(String input) {
        InputTextArchiveImpl inputTextArchive = new InputTextArchiveImpl();
        StopWordArchive stopWordArchive = new StopWordArchive();
        List<String> validWordList = new ArrayList<>();
        Set<String> wordTotalList = inputTextArchive.getAllWords(ROOT_PATH + input);
        Set<String> excludedWordList = stopWordArchive.getAllWords(PATH_STOP_WORD);


        if (wordTotalList != null && !wordTotalList.isEmpty()) {
            for (String word : wordTotalList) {
                if (!word.isEmpty()
                        && word.chars().allMatch(Character::isLetter)
                        && !excludedWordList.contains(word)) {
                    validWordList.add(word);
                }
            }
        }
        return validWordList;
    }

}

