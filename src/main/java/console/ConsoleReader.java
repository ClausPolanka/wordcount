package console;

import dictionary.Dictionary;
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
            while (true) {
                System.out.print("Enter text: ");
                String userInput = scanner.nextLine();

                if (userInput.isEmpty()) {
                    System.out.println("The program is ending because user's input is empty.");
                    break;
                }

                List<String> words = WordCounterUtils.retrieveWordsFromUserInput(userInput);
                WordCounter wordCounter = new WordCounterImpl(words);
                displayWordsNumber(wordCounter, arguments);
            }
        } else {
            List<String> words = WordCounterUtils.retrieveWordsFromResource(arguments.extractExternalResourcePath());
            WordCounter wordCounter = new WordCounterImpl(words);
            displayWordsNumber(wordCounter, arguments);
        }
    }

    private static void displayWordsNumber(WordCounter wordCounter, ConsoleArguments arguments) {
        System.out.println(String.format("Number of words: %d, unique: %d; average word length: %,.2f",
                wordCounter.computeTotalWordsNumber(), wordCounter.computeUniqueWordsNumber(), wordCounter.computeWordLengthAverage()));

        if (arguments.isShowIndexPresent()) {
            if (!arguments.extractDictionaryPath().isEmpty()) {
                displayWordsWithDictionary(wordCounter);
            } else {
                displayWordsWithIndex(wordCounter);
            }
        }
    }

    private static void displayWordsWithDictionary(WordCounter wordCounter) {
        List<String> words = Dictionary.searchInDictionary(wordCounter.retrieveWordsSorted());
        Integer unknownWords = (int) words.stream()
                .filter(word -> word.contains("*")).count();
        System.out.println(String.format("Index (unknown: %d):", unknownWords));
        words.forEach(System.out::println);
    }

    private static void displayWordsWithIndex(WordCounter wordCounter) {
        System.out.println("Index:");
        wordCounter.retrieveWordsSorted().forEach(System.out::println);
    }
}
