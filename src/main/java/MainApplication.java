import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text:");
        String text = scanner.nextLine();

        StopWords stopWords = new StopWords();
        WordCounterService f = new WordCounterService(stopWords.stopWordsAsList());
        int wordCount = f.countWords(text);

        System.out.println("Number of words: " + wordCount);
    }
}
