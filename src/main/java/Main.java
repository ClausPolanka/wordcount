import counter.WordCounter;
import evaluator.Evaluator;
import evaluator.WordEvaluator;
import stopwords.StopWordsFileLoader;
import stopwords.StopWordsLoader;

import java.util.Scanner;
import java.util.Set;

public class Main {

    public Main() {
        final StopWordsLoader stopWordsFileLoader = new StopWordsFileLoader("stopwords.txt");
        final Set<String> stopWordsEntries = stopWordsFileLoader.loadStopWords();
        if (stopWordsEntries == null) {
            // log that something went wrong
            return;
        }

        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Evaluator wordEvaluator = new WordEvaluator();
        WordCounter wordCounter = new WordCounter(wordEvaluator);
        int wordCount = wordCounter.countWords(input, " ");

        System.out.println("Number of words: " + wordCount);
    }

    public static void main(String[] args) {
        new Main();
    }
}
