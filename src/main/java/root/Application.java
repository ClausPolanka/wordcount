package root;

import root.service.impl.ConsoleOutput;
import root.service.impl.ConsoleWordInput;
import root.service.impl.DefaultWordCounter;
import root.service.impl.FileStopWordsProvider;
import root.ui.WordCounterUIInterface;
import root.ui.impl.WordCounterUI;

public class Application {

    public static void main(String[] args) {
        WordCounterUIInterface ui = new WordCounterUI(new ConsoleWordInput(), new ConsoleOutput(),
                new DefaultWordCounter(new FileStopWordsProvider()));
        ui.countWords();
    }

}
