package at.george;

import at.george.counter.StopwordsFilterDecorator;
import at.george.counter.TextSequenceCounter;
import at.george.io.ConsoleReader;
import at.george.io.ConsoleWriter;
import at.george.io.FileReader;
import at.george.io.ResourceBasedStopwordsProvider;

public class WordCountApp {

    public static void main(String[] args) {

        WordCountConfiguration configuration = new WordCountConfiguration(
                new FileReader(args, new ConsoleReader()),
                new StopwordsFilterDecorator(new TextSequenceCounter(), new ResourceBasedStopwordsProvider()),
                new ConsoleWriter()
        );

        new WordCountRunner().run(configuration);
    }
}
