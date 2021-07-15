import java.util.Scanner;

public class InputInterface {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text:");
        String text = scanner.nextLine();

        StopWords stopWords = new StopWords();
        Foo f = new Foo(stopWords.stopWordsAsList());
        int wordCount = f.countWords(text);

        System.out.println("Number of words: " + wordCount);
    }
}
