package root.wordcounter;

import java.text.DecimalFormat;

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

    public void countWords() {
        CountingResult result = wordCounter.countWords(this.input.getInput());
        this.output.print("Number of words: " + result.getNumOfWords() +
                ", unique: " + result.getNumUniqueWords() +
                "; average word length: " + AVERAGE_FORMATTER.format(result.getAverageWordLen()) +" characters");
    }
}
