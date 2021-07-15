import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        WordCounterApplication wordCounterApplication = new WordCounterApplication(args);
        System.out.println(wordCounterApplication.countWordsFromInput());
    }
}
