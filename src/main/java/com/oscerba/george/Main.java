package com.oscerba.george;

import com.oscerba.george.config.ApplicationConfig;
import com.oscerba.george.config.ApplicationConfigParser;
import com.oscerba.george.input.*;
import com.oscerba.george.output.ConsoleWriter;
import com.oscerba.george.output.Writeable;
import com.oscerba.george.parser.WordParser;
import com.oscerba.george.processor.WordProcessor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfigParser().parse(args);
        WordInputReader wordInputReader;
        List<String> words = new ArrayList<>();
        List<String> stopWords = new ArrayList<>();
        try {
            wordInputReader = new WordInputReaderFactory().getWordInputReader(applicationConfig.getWordsInputFilePath());

            words = new WordParser().getWords(wordInputReader.getWords());

            stopWords = new StopWordFileInputReader(applicationConfig.getStopWordsInputFilePath()).getStopWords();
        } catch (IOException e) {
            e.printStackTrace();
        }

        WordProcessor wordProcessor = new WordProcessor(words, stopWords);

        Writeable writeable = new ConsoleWriter(wordProcessor.getStatistics(), applicationConfig.isIndexEnabled());
        writeable.write();
    }
}
