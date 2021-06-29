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

    public void start(){

        System.out.print(WELCOME_MESSAGE);
        String line = scanner.nextLine();
        System.out.println(RESULT_MESSAGE + wordCount.getNumberOfWords(line));
    }
}
