package com.ableneo.erste.wordcount;

import com.ableneo.erste.wordcount.cli.CliParameters;
import com.ableneo.erste.wordcount.cli.CliParser;
import com.ableneo.erste.wordcount.counter.CounterResult;
import com.ableneo.erste.wordcount.counter.WordCounter;
import com.ableneo.erste.wordcount.filter.StopWordsFilter;
import com.ableneo.erste.wordcount.ui.CommandLineBasedAbstractUI;
import com.ableneo.erste.wordcount.ui.FileBasedAbstractUI;
import com.ableneo.erste.wordcount.ui.AbstractUI;

import java.io.IOException;

public class WordCountApplication {

    public static void main(String[] args) throws IOException {

        CliParser cliParser = new CliParser();
        CliParameters cliParameters = cliParser.parse(args);

        StopWordsFilter stopWordsFilter = new StopWordsFilter("stopwords/stopwords.txt");
        WordCounter wordCounter = new WordCounter(stopWordsFilter);

        AbstractUI ui = cliParameters.isFileBasedInput()
                ? new FileBasedAbstractUI(cliParameters.getInputFileName()) : new CommandLineBasedAbstractUI();

        CounterResult result = wordCounter.count(ui.getInput());
        ui.writeResults(result, cliParameters.isPrintIndex());
    }
}
