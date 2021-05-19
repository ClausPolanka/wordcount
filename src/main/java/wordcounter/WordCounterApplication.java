package wordcounter;

import wordcounter.counter.WordCounter;
import wordcounter.reader.StopWordReaderFromFile;
import wordcounter.userinterface.UserInterface;

import java.util.List;

public class WordCounterApplication {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface(System.in, System.out);
        String userInput = userInterface.getInput();

        List<String> stopWords = new StopWordReaderFromFile("stopwords.txt").getStopWords();
        WordCounter wordCounter = new WordCounter(stopWords);
        wordCounter.setText(userInput);

        int numberOfWordsInUserInput = wordCounter.countWords();
        userInterface.showOutput(numberOfWordsInUserInput);
    }
}
