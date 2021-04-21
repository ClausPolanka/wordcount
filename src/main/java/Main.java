import counter.WordCounter;
import evaluator.Evaluator;
import evaluator.WordEvaluator;
import stopwords.StopWordsFileLoader;
import stopwords.StopWordsLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public Main(final WordCounter wordCounter, final InputStream userInput) {
        Scanner scanner = new Scanner(userInput);
        String input = scanner.nextLine();

        int wordCount = wordCounter.countWords(input, " ");

        System.out.println("Number of words: " + wordCount);
    }

    private static InputStream selectAppropriateInputSource(String[] cliArgs) {
        if (cliArgs == null || cliArgs.length == 0) {
            return System.in;
        }
        final String inputFilename = cliArgs[0];
        final ClassLoader classLoader = Main.class.getClassLoader();
        final URL stopwordsFileresource = classLoader.getResource(inputFilename);
        if (stopwordsFileresource == null) {
            // log that something went wrong
            return System.in;
        }
        final File stopwordsFile = new File(stopwordsFileresource.getFile());
        try {
            return new FileInputStream(stopwordsFile);
        } catch (FileNotFoundException e) {
            // log a message here
            return System.in;
        }
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

        new Main(wordCounter, selectAppropriateInputSource(args));
    }
}
