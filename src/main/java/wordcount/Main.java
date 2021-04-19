package wordcount;

import wordcount.impl.WordCounterAllowedDashImpl;
import wordcount.util.FileUtils;

import java.util.Scanner;

public class Main {

    private final IWordCounter wordCounter;

    public Main(IWordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    public static void main(String[] args) {
        final Main main = new Main(new WordCounterAllowedDashImpl("stopwords.txt"));
        String fileName = null;
        boolean printIndex = false;
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-index":
                    printIndex = true;
                    break;
                default:
                    fileName = args[i];
            }
        }
        final String inputText = fileName != null ? main.readInput(fileName) : main.readInput();

        main.printOutput(inputText);
        if (printIndex) {
            main.printIndex(inputText);
        }
    }

    private void printOutput(String inputText) {
        System.out.println("Number of words: " + wordCounter.count(inputText) +
                ", unique: " + wordCounter.countUnique(inputText) +
                "; average word length: " + wordCounter.averageLength(inputText) + " characters");
    }

    private void printIndex(String inputText) {
        System.out.println("Index:");
        wordCounter.getIndex(inputText).forEach(System.out::println);
    }

    public String readInput() {
        System.out.print("Enter text: ");
        return new Scanner(System.in).nextLine();
    }

    public String readInput(final String fileName) {
        return FileUtils.readFileAsString(fileName);
    }
}
