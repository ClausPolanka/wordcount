package wordcount;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Main main = new Main();
        final String inputText = main.readInput();
        final IWordCounter wordCounter = new WordCounterImpl("stopwords.txt");
        System.out.print("Number of words: " + wordCounter.count(inputText));
    }

    public String readInput() {
        final Scanner scanner = new Scanner(System.in);
        final StringBuilder sb = new StringBuilder();
        System.out.print("Enter text: ");
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
        }
        return sb.toString();
    }
}
