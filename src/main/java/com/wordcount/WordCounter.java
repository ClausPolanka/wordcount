package com.wordcount;

import java.util.List;

public class WordCounter {

    private InputUserImpl userInput;
    private ProcessDataImpl processUserInput;

    public WordCounter(InputUserImpl userInput, ProcessDataImpl processUserInput) {
        this.userInput = userInput;
        this.processUserInput = processUserInput;
    }

    public void countWords() {
        System.out.print("Enter text: ");
        String userGivenInput = userInput.getUserInput();
        List<String> userWord = processUserInput.processUserInput(userGivenInput);
        System.out.print("Number of words:" + userWord.size());
    }
}

