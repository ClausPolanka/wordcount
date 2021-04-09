package controller;

import io.UserInterface;
import model.WordDetailsDTO;
import service.WordCountService;

public class WordCountController {

    UserInterface ui;
    WordCountService wordCountService;

    public WordCountController(UserInterface ui, WordCountService wordCountService) {

        this.ui = ui;
        this.wordCountService = wordCountService;

    }

    public void countWords() {

        final String input = ui.getInput();

        final WordDetailsDTO wordDetailsDTO = wordCountService.getWordDetails(input);

        ui.displayOutput(wordDetailsDTO);

    }

}
