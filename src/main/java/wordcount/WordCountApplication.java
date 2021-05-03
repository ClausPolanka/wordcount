package wordcount;

import wordcount.counter.SimpleWordCounter;
import wordcount.counter.delimiter.RegexSentenceSplitter;
import wordcount.counter.matcher.CompositeWordMatcher;
import wordcount.counter.matcher.RegexWordMatcher;
import wordcount.counter.matcher.StopWordsWordMatcher;
import wordcount.reader.InputReader;
import wordcount.reader.InputReaderImpl;
import wordcount.writer.OutputWriter;
import wordcount.writer.OutputWriterImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Application for counting how many words are in a sentence
 */
public class WordCountApplication {

    public WordCountApplication(InputReader inputReader, OutputWriter outputWriter, List<String> stopWords)
            throws IOException {
        CompositeWordMatcher compositeWordMatcher = createCompositeWordMatcher(stopWords);
        SimpleWordCounter wordCounter = new SimpleWordCounter(new RegexSentenceSplitter(), compositeWordMatcher);

        List<String> input = inputReader.readLines();
        int wordCounts = wordCounter.countWords(input);
        outputWriter.writeResult("Number of words: " + wordCounts);
    }

    public static void main(String[] args) {
        try {
            List<String> stopWords = Files.readAllLines(Paths.get("resources/stopwords.txt"));
            if (args.length == 0) {
                //Start with console
                System.out.print("Enter text: ");
                new WordCountApplication(new InputReaderImpl(), new OutputWriterImpl(), stopWords);
            } else {
                //start with file
                new WordCountApplication(new InputReaderImpl(new FileInputStream(args[0])), new OutputWriterImpl(),
                        stopWords);
            }
        } catch (Exception e) {
            System.err.println("Exception happened in a programm: " + e);
        }
    }

    private CompositeWordMatcher createCompositeWordMatcher(List<String> stopWords) {
        StopWordsWordMatcher stopWordsWordMatcher = new StopWordsWordMatcher(stopWords, new RegexWordMatcher());
        return new CompositeWordMatcher(Arrays.asList(stopWordsWordMatcher, new RegexWordMatcher()));
    }

}
