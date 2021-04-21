import counter.UniqueWordsCounter;
import counter.WordCounter;
import filters.StopWordsFilter;
import stats.WordsStats;
import stopwords.StopWordsFileLoader;
import stopwords.StopWordsLoader;
import ui.UserInterface;
import ui.UserInterfaceFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final StopWordsLoader stopWordsFileLoader = new StopWordsFileLoader("stopwords.txt");
        final StopWordsFilter stopWordsFilter = new StopWordsFilter(stopWordsFileLoader.loadStopWords());
        final WordCounter wordCounter = new WordCounter();
        final UniqueWordsCounter uniqueWordsCounter = new UniqueWordsCounter();

        final UserInterface userInterface = UserInterfaceFactory.createUserInterface(args);

        final Scanner scanner = new Scanner(userInterface.getUserInput());
        userInterface.askForInput();
        final String rawSentence = scanner.nextLine();
        final String stopWordsFilteredSentence = stopWordsFilter.filter(rawSentence);

        userInterface.printStats(
                new WordsStats(wordCounter.countWords(stopWordsFilteredSentence),
                        uniqueWordsCounter.countUniqueWords(stopWordsFilteredSentence)
                ));
    }
}
