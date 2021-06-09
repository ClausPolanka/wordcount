package root.ui.impl;

import root.service.OutputInterface;
import root.service.WordCounterInterface;
import root.service.WordInputInterface;
import root.ui.WordCounterUIInterface;

public class WordCounterUI implements WordCounterUIInterface {

    private final WordInputInterface input;
    private final OutputInterface output;
    private final WordCounterInterface wordCounter;

    public WordCounterUI(WordInputInterface input, OutputInterface output, WordCounterInterface wordCounter) {
        this.input = input;
        this.output = output;
        this.wordCounter = wordCounter;
    }

    @Override
    public void countWords() {
        long number = wordCounter.countWords(this.input.getInput());
        this.output.print("Number of words: " + number);
    }
}
