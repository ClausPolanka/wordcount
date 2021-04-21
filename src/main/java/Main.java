

import java.util.Scanner;

public class Main {

    public Main() {
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
