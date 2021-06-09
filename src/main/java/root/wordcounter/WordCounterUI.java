package root.wordcounter;

import root.wordcounter.data.CountingResult;

import java.text.DecimalFormat;
import java.util.List;

public class WordCounterUI {

    private final static DecimalFormat AVERAGE_FORMATTER = new DecimalFormat("#.##");

    private final InputInterface input;
    private final OutputInterface output;
    private final WordCounter wordCounter;


    public WordCounterUI(InputInterface input, OutputInterface output, WordCounter wordCounter) {
        this.input = input;
        this.output = output;
        this.wordCounter = wordCounter;
    }

    public void countWords(boolean printIndex) {
        CountingResult result = wordCounter.countWords(this.input.getInput());
        this.output.print("Number of words: " + result.getNumOfWords() +
                ", unique: " + result.getNumUniqueWords() +
                "; average word length: " + AVERAGE_FORMATTER.format(result.getAverageWordLen()) +" characters");

        if(printIndex) {
            printIndex(result.getIndex());
        }
    }

    private void printIndex(List<String> index) {
        this.output.print(System.lineSeparator());
        this.output.print("Index:");
        this.output.print(System.lineSeparator());
        this.output.print(String.join(System.lineSeparator(), index));
    }
}
