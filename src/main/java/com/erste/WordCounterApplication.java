package com.erste;

import com.erste.controller.FileUserInterface;
import com.erste.controller.StandardInAndOutputUserInterface;
import com.erste.controller.UserInterface;
import com.erste.service.WordCountManager;

public class WordCounterApplication {

    public static void main(String[] args) {

        String inputFileName = null;

        if (args.length == 1) {
            inputFileName = args[0];
        }

        WordCountManager wordCountManager = new WordCountManager();
        UserInterface userInterface = new StandardInAndOutputUserInterface();
        UserInterface fileUserInterface = new FileUserInterface("stopwords.txt");
        String stopWords = fileUserInterface.getInput();

        String input;
        if (inputFileName != null && !inputFileName.isEmpty()) {
            fileUserInterface = new FileUserInterface(inputFileName);
            input = fileUserInterface.getInput();
        } else {
            input = userInterface.getInput();
        }

        long count = wordCountManager.countWords(input, stopWords);
        long uniqueCount = wordCountManager.countUniqueWords(input, stopWords);
        userInterface.show(count, uniqueCount);
    }

}
