package sk.sloboda.wordcount;

import java.util.Scanner;

import sk.sloboda.wordcount.common.ArgumentHelper;
import sk.sloboda.wordcount.common.WordCounter;
import sk.sloboda.wordcount.common.WordCounterImpl;
import sk.sloboda.wordcount.validator.WordValidatorImpl;


public class WordCounterApp {

    public static void main(String[] args) {
        new WordCounterApp().run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter file name or press enter.");

        WordCounter counter = new WordCounterImpl(new WordValidatorImpl());
        ArgumentHelper argumentHelper = new ArgumentHelper();

        String firstInput = scanner.nextLine();
        if (argumentHelper.isFileNameEntered(firstInput)) {
            displayResult(counter.countWords(argumentHelper.loadTextFromFile()));
        } else {
            System.out.println("Please enter your sentence.");
            displayResult(counter.countWords(scanner.nextLine()));
        }
    }

    private void displayResult(long numberOfWords) {
        System.out.printf("You entered sentence with: ' %s ' words.%n", numberOfWords);
    }
}
