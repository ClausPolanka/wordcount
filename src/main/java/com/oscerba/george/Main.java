package com.oscerba.george;

import com.oscerba.george.input.*;
import com.oscerba.george.output.ConsoleWriter;
import com.oscerba.george.output.Writeable;
import com.oscerba.george.parser.WordParser;
import com.oscerba.george.processor.WordProcessor;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final String STOPWORDS_INPUT = "src/main/resources/stopwords.txt";

    public static void main(String[] args) {
        WordInputReader wordInputReader;
        List<String> words = new ArrayList<>();
        List<String> stopWords = new ArrayList<>();
        try {
            wordInputReader = new WordInputReaderFactory().getWordInputReader(args);

            words = new WordParser().getWords(wordInputReader.getWords());

            Path path = Paths.get(STOPWORDS_INPUT);

            stopWords = new StopWordFileInputReader(path).getStopWords();
        } catch (IOException e) {
            e.printStackTrace();
        }

        WordProcessor wordProcessor = new WordProcessor(words, stopWords);

        Writeable writeable = new ConsoleWriter(wordProcessor.getStatistics());
        writeable.write();
    }
}
