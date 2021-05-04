package sk.sloboda.wordcount;

import java.util.Scanner;

import sk.sloboda.wordcount.common.WordCounter;
import sk.sloboda.wordcount.common.WordCounterImpl;
import sk.sloboda.wordcount.validator.WordValidatorImpl;


public class WordCounterApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your sentence.");

        WordCounter counter = new WordCounterImpl(new WordValidatorImpl());
        System.out.printf("You entered sentence with: %s words.", counter.countWords(scanner.nextLine()));
    }
}
