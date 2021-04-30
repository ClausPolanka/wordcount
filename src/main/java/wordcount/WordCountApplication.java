package wordcount;

import wordcount.counter.SimpleWordCounter;
import wordcount.counter.WordCounter;
import wordcount.reader.InputReader;
import wordcount.reader.InputReaderImpl;
import wordcount.writer.OutputWriter;
import wordcount.writer.OutputWriterImpl;

import java.io.IOException;

/**
 * Application for counting how many words are in a sentence
 */
public class WordCountApplication {

    public WordCountApplication(InputReader inputReader, OutputWriter outputWriter) throws IOException {
        System.out.print("Enter text: ");
        String input = inputReader.readLine();
        WordCounter wordCounter = new SimpleWordCounter();
        int wordsCount = wordCounter.countWords(input);
        outputWriter.writeResult("Number of words: " + wordsCount);
    }

    public static void main(String[] args) throws IOException {
        new WordCountApplication(new InputReaderImpl(), new OutputWriterImpl());
    }

}
