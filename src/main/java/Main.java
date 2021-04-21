import counter.WordCounter;
import evaluator.WordEvaluator;
import stopwords.StopWordsFileLoader;
import stopwords.StopWordsLoader;
import ui.UserInterface;
import ui.UserInterfaceFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final StopWordsLoader stopWordsFileLoader = new StopWordsFileLoader("stopwords.txt");
        final WordCounter wordCounter = new WordCounter(new WordEvaluator(stopWordsFileLoader.loadStopWords()));

        final UserInterface userInterface = UserInterfaceFactory.createUserInterface(args);

        final Scanner scanner = new Scanner(userInterface.getUserInput());

        userInterface.printWordsCount(wordCounter.countWords(scanner.nextLine(), " "));
    }
}
