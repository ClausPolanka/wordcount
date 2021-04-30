package com.oscerba.george;

import com.oscerba.george.input.ConsoleWordProvider;
import com.oscerba.george.input.WordProvider;
import com.oscerba.george.output.ConsoleWriter;
import com.oscerba.george.output.Writeable;
import com.oscerba.george.processor.WordProcessor;

public class Main {

    public static void main(String[] args) {
        WordProvider consoleWordProvider = new ConsoleWordProvider();
        String[] words = consoleWordProvider.getWords();

        WordProcessor wordProcessor = new WordProcessor(words);

        Writeable writeable = new ConsoleWriter(wordProcessor.getCount());
        writeable.write();

    }
}
