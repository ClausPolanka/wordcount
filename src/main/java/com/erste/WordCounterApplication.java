package com.erste;

import com.erste.controller.FileUserInterface;
import com.erste.controller.StandardInAndOutputUserInterface;
import com.erste.controller.UserInterface;
import com.erste.service.WordCountManager;

public class WordCounterApplication {
    public static void main(String[] args) {
        WordCountManager wordCountManager = new WordCountManager();
        UserInterface userInterface = new StandardInAndOutputUserInterface();
        UserInterface fileUserInterface = new FileUserInterface("stopwords.txt");
        String stopWords = fileUserInterface.getInput();
        String input = userInterface.getInput();
        long count = wordCountManager.countWords(input, stopWords);
        userInterface.show(count);
    }
}
