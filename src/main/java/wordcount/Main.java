package wordcount;

import wordcount.impl.WordCounterAllowedDashImpl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final Main main = new Main();
        String fileName = null;
        if (args.length > 0) {
            fileName = args[0];
        }
        final String inputText = fileName != null ? main.readInput(fileName) : main.readInput();

        final IWordCounter wordCounter = new WordCounterAllowedDashImpl("stopwords.txt");
        System.out.print("Number of words: " + wordCounter.count(inputText) + ", unique: " + wordCounter.countUnique(inputText));
    }

    public String readInput() {
        System.out.print("Enter text: ");
        return new Scanner(System.in).nextLine();
    }

    public String readInput(final String fileName) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(fileName));
            return new String(encoded, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
