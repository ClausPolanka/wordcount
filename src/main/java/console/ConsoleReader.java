package console;

import wordcounter.WordCounter;
import wordcounter.WordCounterImpl;
import wordcounter.WordCounterUtils;

import java.util.List;
import java.util.Scanner;

public final class ConsoleReader {

    private ConsoleReader() {
        // private access
    }

    public static void startConsole() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("wordcount ");
        ConsoleArguments arguments = new ConsoleArguments(scanner.nextLine());

        if (arguments.extractExternalResourcePath().isEmpty()) {
            System.out.print("Enter text: ");
            String userInput = scanner.nextLine();
            List<String> words = WordCounterUtils.retrieveWordsFromUserInput(userInput);
            WordCounter wordCounter = new WordCounterImpl(words);
            displayWordsNumber(wordCounter);
        } else {
            List<String> words = WordCounterUtils.retrieveWordsFromResource(arguments.extractExternalResourcePath());
            WordCounter wordCounter = new WordCounterImpl(words);
            displayWordsNumber(wordCounter);
        }
    }

    private static void displayWordsNumber(WordCounter wordCounter) {
        System.out.println(String.format("Number of words: %d", wordCounter.computeTotalWordsNumber()));
    }
}
