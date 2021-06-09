package root.ui.impl;

import root.service.OutputInterface;
import root.service.WordCounterInterface;
import root.service.WordInputInterface;
import root.ui.WordCounterUIInterface;

public class WordCounterUI implements WordCounterUIInterface {

    private WordInputInterface input;
    private OutputInterface output;
    private WordCounterInterface wordCounter;

    public WordCounterUI(WordInputInterface input, OutputInterface output, WordCounterInterface wordCounter) {
        this.input = input;
        this.output = output;
        this.wordCounter = wordCounter;
    }

    @Override
    public void countWords() {
        this.output.print("Enter text: ");
        long number = wordCounter.countWords(this.input.getInput());
        this.output.print("Number of words: " + number);
    }
}
