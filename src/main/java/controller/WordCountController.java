package controller;

import io.InputOutputInterface;
import org.apache.commons.lang3.StringUtils;
import service.WordCountService;

import java.io.IOException;

public class WordCountController {

    InputOutputInterface io;
    WordCountService wordCountService;

    public WordCountController(InputOutputInterface io, WordCountService wordCountService) {

        this.io = io;
        this.wordCountService = wordCountService;

    }

    public String countWords() {

        String output = StringUtils.EMPTY;

        try {

            final String input = io.getInput();

            final String count = String.valueOf(wordCountService.getWordCount(input));

            output = io.displayOutput(count);


        } catch (IOException exception) {

            System.out.println("IO Exception" + exception.getMessage());

        }

        return output;

    }

}
