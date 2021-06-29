import exceptions.FormatException;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerInput {

    private Scanner scanner;

    private WordCount wordCount;

    private static final String WELCOME_MESSAGE = "Enter text: ";

    private static final String RESULT_MESSAGE = "Number of words: ";

    public ScannerInput(){
        scanner = new Scanner(System.in);
        wordCount = new WordCount();
    }

    public void start() throws FileNotFoundException, FormatException {

        String line = scanner.nextLine();

        if (line == null || line.isEmpty()) {
            System.out.print(WELCOME_MESSAGE);
            line = scanner.nextLine();
            System.out.println(RESULT_MESSAGE + wordCount.getNumberOfWords(line, true));
        } else{
            System.out.println(RESULT_MESSAGE + wordCount.getNumberOfWordsFromFile(line));
        }
    }
}
