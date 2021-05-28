package com.erste.service;

public class WordCountManager {

    public Integer countWords(String input){
        if (input == null) {
            return 0;
        }
        String[] potentialWords = input.split("\\s");
        Integer wordCounter = 0;
        for (int i = 0; i < potentialWords.length; i++) {
            if (potentialWords[i].matches("[a-zA-Z]+")){
                wordCounter++;
            }
        }

        return wordCounter;
    }

}
