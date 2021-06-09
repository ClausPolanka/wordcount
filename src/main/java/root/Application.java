package root;

import root.wordcounter.*;
import root.infrastructure.ConsoleOutput;
import root.infrastructure.FileStopWordsProvider;
import root.wordcounter.data.Args;

public class Application {

    public static void main(String[] args) {
        OutputInterface output = new ConsoleOutput();
        InputFactory factory = new InputFactory(output);

        Args parsedArgs = ArgParser.parseArgs(args);

        InputInterface input = factory.createInput(parsedArgs.getFilename());
        FileStopWordsProvider stopWordsProvider = new FileStopWordsProvider();

        WordCounterUI ui = new WordCounterUI(input, output,
                new WordCounter(stopWordsProvider.getStopWords()));
        ui.countWords(parsedArgs.printIndex());
    }

}
