package controller;

import io.InputOutputInterface;
import service.WordCountService;

import java.io.IOException;

public class WordCountController {

    InputOutputInterface io;
    WordCountService wordCountService;

    public void countWords() {

        try {

            final String input = io.getInput();

            final int output = wordCountService.getWordCount(input);

            io.displayOutput(String.valueOf(output));

        } catch (IOException exception) {

            System.out.println("IO Exception" + exception.getMessage());

        }

    }

}
