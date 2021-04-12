package com.ableneo.erste.wordcount;

import com.ableneo.erste.wordcount.counter.CounterResult;
import com.ableneo.erste.wordcount.counter.WordCounter;
import com.ableneo.erste.wordcount.filter.StopWordsFilter;
import com.ableneo.erste.wordcount.ui.CommandLineBasedAbctractUI;
import com.ableneo.erste.wordcount.ui.FileBasedAbctractUI;
import com.ableneo.erste.wordcount.ui.AbctractUI;

import java.io.IOException;

public class WordCountApplication {

    public static void main(String[] args) throws IOException {

        StopWordsFilter stopWordsFilter = new StopWordsFilter("stopwords/stopwords.txt");
        WordCounter wordCounter = new WordCounter(stopWordsFilter);

        AbctractUI ui = args.length > 0 ? new FileBasedAbctractUI(args[0]) : new CommandLineBasedAbctractUI();

        CounterResult result = wordCounter.count(ui.getInput());
        ui.writeResults(result);
    }
}
