package wordcounter;

import wordcounter.counter.WordCounter;
import wordcounter.reader.StopWordReaderFromFile;
import wordcounter.userinterface.UserInterfaceHandler;
import wordcounter.userinterface.UserInterfaceHandlerConsole;
import wordcounter.userinterface.UserInterfaceHandlerFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class WordCounterApplication {
    public static void main(String[] args) {
        UserInterfaceHandler userInterfaceHandler;
        if (args.length > 0) {
            try {
                userInterfaceHandler = new UserInterfaceHandlerFile(new FileInputStream(args[0]), System.out);
            } catch (FileNotFoundException e) {
                userInterfaceHandler = new UserInterfaceHandlerConsole(System.in, System.out);
            }
        } else {
            userInterfaceHandler = new UserInterfaceHandlerConsole(System.in, System.out);
        }
        String userInput = userInterfaceHandler.getInput();

        List<String> stopWords = new StopWordReaderFromFile("stopwords.txt").getStopWords();
        int numberOfWordsInUserInput = new WordCounter(stopWords).countWordsIn(userInput);

        userInterfaceHandler.showOutput(numberOfWordsInUserInput);
    }
}
