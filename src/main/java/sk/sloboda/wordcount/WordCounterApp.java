package sk.sloboda.wordcount;

import java.util.List;
import java.util.Scanner;

import sk.sloboda.wordcount.common.ArgumentHelper;
import sk.sloboda.wordcount.common.WordCounter;
import sk.sloboda.wordcount.common.WordCounterImpl;
import sk.sloboda.wordcount.model.WordCount;
import sk.sloboda.wordcount.validator.WordValidatorImpl;


public class WordCounterApp {

    public static void main(String[] args) {
        new WordCounterApp().run(args);
    }

    public void run(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter file name or press enter.");

        WordCounter counter = new WordCounterImpl(new WordValidatorImpl());
        ArgumentHelper argumentHelper = new ArgumentHelper();

        String firstInput = scanner.nextLine();
        WordCount result;
        if (argumentHelper.isFileNameEntered(firstInput)) {
            result = counter.countWords(argumentHelper.loadTextFromFile());
        } else {
            System.out.println("Please enter your sentence.");
            result = counter.countWords(scanner.nextLine());
        }

        if (argumentHelper.showIndex(args)) {
            displayResultWithIndex(result, argumentHelper.loadDictionary(args));
        } else {
            displayResult(result);
        }
    }

    private void displayResult(WordCount wordCount) {
        System.out.printf("Number of words: %s, unique: %s; average word length: %,.2f %n", wordCount.getCount(), wordCount.getUniqueCount(), wordCount.getAverageLength());
    }

    private void displayResultWithIndex(WordCount wordCount, List<String> dictionary) {
        displayResult(wordCount);
        System.out.println("Index:");
        wordCount.getSortedWords().forEach(word -> {
            if (dictionary != null && !dictionary.isEmpty() && dictionary.contains(word)) {
                System.out.println(word);
            } else {
                System.out.printf("%s*%n", word);
            }
        });
    }
}
