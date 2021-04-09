package controller;

import io.UserInterface;
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
        final int count = wordCountService.getWordCount(input);
        ui.displayOutput(count);

    }

}
