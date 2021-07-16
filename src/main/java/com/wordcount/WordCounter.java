package com.wordcount;

import java.io.File;
import java.util.List;

public class WordCounter {
    public static final String ROOT_PATH  = "src/resources/";
    private final InputUserImpl userInput;
    private final ProcessDataImpl processUserInput;
    private final ProcessTextDataImpl processTextDataInput;

    public WordCounter(InputUserImpl userInput, ProcessDataImpl processUserInput, ProcessTextDataImpl processTextDataInput) {
        this.userInput = userInput;
        this.processUserInput = processUserInput;
        this.processTextDataInput = processTextDataInput;
    }

    public void countWords() {
        String userGivenInputText= userInput.getUserInput();
        List<String> textWord;
        if(userGivenInputText != null && new File(ROOT_PATH + userGivenInputText).exists())   {
            textWord = processTextDataInput.processUserInput(userGivenInputText);
        }
        else{
            System.out.println("Enter text: ");
            String userGivenInput = userInput.getUserInput();
            textWord = processUserInput.processUserInput(userGivenInput);
        }
        System.out.print("Number of words:" + textWord.size());
    }
}

