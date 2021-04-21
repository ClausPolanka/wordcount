

import counter.WordCounter;
import evaluator.Evaluator;
import evaluator.WordEvaluator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public Main() {
        final Set<String> stopwords = loadStopWords();
        if (stopwords == null) {
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

    private Set<String> loadStopWords() {
        Set<String> words = new HashSet();
        final String fileName = "stopwords.txt";
        final ClassLoader classLoader = getClass().getClassLoader();

        final URL stopwordsFileresource = classLoader.getResource(fileName);
        if (stopwordsFileresource == null) {
            return null;
        }

        final File stopwordsFile = new File(stopwordsFileresource.getFile());

        final BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(stopwordsFile));
            String line = reader.readLine();
            while (line != null) {
                if (line != null && !line.trim().isEmpty()) {
                    words.add(line);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            return null;
        }

        return null;
    }

    public static void main(String[] args) {
        new Main();
    }
}
