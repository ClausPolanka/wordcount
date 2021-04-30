package com.oscerba.george;

import com.oscerba.george.input.WordConsoleInputReader;
import com.oscerba.george.input.StopWordFileInputReader;
import com.oscerba.george.input.WordFileInputReader;
import com.oscerba.george.input.WordInputReader;
import com.oscerba.george.output.ConsoleWriter;
import com.oscerba.george.output.Writeable;
import com.oscerba.george.processor.WordProcessor;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        WordInputReader consoleWordInputReader;
        try {
            if (args.length > 0) {
                Path path = Paths.get(args[0]);
                consoleWordInputReader = new WordFileInputReader(path);
            } else {
                consoleWordInputReader = new WordConsoleInputReader();
            }

            List<String> words = consoleWordInputReader.getWords();

            Path path = Paths.get("src/main/resources/stopwords.txt");
            List<String> stopWords = new ArrayList<>();

            stopWords = new StopWordFileInputReader(path).getStopWords();
        } catch (IOException e) {
            e.printStackTrace();
        }

        WordProcessor wordProcessor = new WordProcessor(words, stopWords);

        Writeable writeable = new ConsoleWriter(wordProcessor.getCount());
        writeable.write();
    }
}
