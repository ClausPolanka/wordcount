package root;

import root.service.InputFactory;
import root.service.OutputInterface;
import root.service.WordInputInterface;
import root.service.impl.ConsoleOutput;
import root.service.impl.ConsoleWordInput;
import root.service.impl.DefaultWordCounter;
import root.service.impl.FileStopWordsProvider;
import root.ui.WordCounterUIInterface;
import root.ui.impl.WordCounterUI;

public class Application {

    public static void main(String[] args) {
        OutputInterface output = new ConsoleOutput();
        InputFactory factory = new InputFactory(output);
        WordInputInterface input = factory.createInput(args);

        WordCounterUIInterface ui = new WordCounterUI(input, output,
                new DefaultWordCounter(new FileStopWordsProvider()));
        ui.countWords();
    }

}
