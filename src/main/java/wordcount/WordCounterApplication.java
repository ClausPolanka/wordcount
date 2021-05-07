package wordcount;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;

public class WordCounterApplication {
    private ResponseBuilder responseBuilder = new ResponseBuilder();
    private final BufferedReader reader;
    private final BufferedWriter writer;
    private final StopwordsProvider stopwordsProvider;

    public WordCounterApplication(BufferedReader reader,
                                  BufferedWriter writer,
                                  StopwordsProvider stopwordsProvider) {
        this.reader = reader;
        this.writer = writer;
        this.stopwordsProvider = stopwordsProvider;
    }

    public void run(String[] args) {
        //change non default ones
        WordCounterOptions defaultOptions = new WordCounterOptions();
        defaultOptions.setStopWords(stopwordsProvider.getStopWords());

        WordCounter wordCounter = new WordCounter(defaultOptions);

        String inputText = createTextProvider(args).readInputText();

        WordCounterOutput count = wordCounter.count(inputText);

        try {
            writer.write(responseBuilder.createOutputMessage(count));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }

    private InputTextProvider createTextProvider(String[] args) {
        InputTextProvider textProvider;
        if (args.length > 0) {
            textProvider = new FromFileInputTextProvider(args[0]);
        } else {
            textProvider = new FromConsoleTextProvider(reader);
        }
        return textProvider;
    }

}
