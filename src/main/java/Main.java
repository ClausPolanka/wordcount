import counter.WordCounter;
import evaluator.Evaluator;
import evaluator.WordEvaluator;
import stopwords.StopWordsFileLoader;
import stopwords.StopWordsLoader;

import java.io.InputStream;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public Main(final WordCounter wordCounter, final InputStream userInput) {
        System.out.print("Enter text: ");
        Scanner scanner = new Scanner(userInput);
        String input = scanner.nextLine();

        int wordCount = wordCounter.countWords(input, " ");

        System.out.println("Number of words: " + wordCount);
    }

    public static void main(String[] args) {
        final StopWordsLoader stopWordsFileLoader = new StopWordsFileLoader("stopwords.txt");
        Set<String> stopWords = stopWordsFileLoader.loadStopWords();
        if (stopWords == null) {
            // log something here
            return;
        }
        final Evaluator wordsEvaluator = new WordEvaluator(stopWords);
        final WordCounter wordCounter = new WordCounter(wordsEvaluator);

        new Main(wordCounter, System.in);
    }
}
