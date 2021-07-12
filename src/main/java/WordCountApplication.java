import com.wordcount.WordCounter;

import java.io.InputStreamReader;
import java.util.Scanner;

public class WordCountApplication {

    public static void main(String[] args) {
        WordCounter wc = new WordCounter();
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Enter text: ");
        String input = scanner.nextLine();
        long numberOfWords = wc.countWords(input);
        System.out.println("Number of words: " + numberOfWords);
    }
}
