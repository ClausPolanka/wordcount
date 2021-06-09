package root;

import root.wordcounter.InputFactory;
import root.wordcounter.OutputInterface;
import root.wordcounter.InputInterface;
import root.infrastructure.ConsoleOutput;
import root.wordcounter.WordCounter;
import root.infrastructure.FileStopWordsProvider;
import root.wordcounter.WordCounterUI;

public class Application {

    public static void main(String[] args) {
        OutputInterface output = new ConsoleOutput();
        InputFactory factory = new InputFactory(output);
        InputInterface input = factory.createInput(args);
        FileStopWordsProvider stopWordsProvider = new FileStopWordsProvider();

        WordCounterUI ui = new WordCounterUI(input, output,
                new WordCounter(stopWordsProvider.getStopWords()));
        ui.countWords();
    }

}
