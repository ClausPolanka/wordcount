package wordcount;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Main main = new Main();
        String fileName = null;
        if (args.length > 0) {
            fileName = args[0];
        }
        final String inputText = fileName != null ? main.readInput(new File(fileName)) : main.readInput();

        final IWordCounter wordCounter = new WordCounterImpl("stopwords.txt");
        System.out.print("Number of words: " + wordCounter.count(inputText));
    }

    public String readInput() {
        System.out.print("Enter text: ");
        return readInputInternal(System.in);
    }

    public String readInput(File file) {
        try (InputStream is = new FileInputStream(file)) {
            return readInputInternal(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String readInputInternal(InputStream is) {
        final Scanner scanner = new Scanner(is);
        final StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
        }
        return sb.toString();
    }
}
