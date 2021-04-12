package com.ableneo.erste.wordcount;

import com.ableneo.erste.wordcount.filter.StopWordsFilter;
import com.ableneo.erste.wordcount.ui.CommandLineBasedUI;
import com.ableneo.erste.wordcount.ui.FileBasedUI;
import com.ableneo.erste.wordcount.ui.UI;

import java.io.IOException;

public class WordCountApplication {

    public static void main(String[] args) throws IOException {

        StopWordsFilter stopWordsFilter = new StopWordsFilter("stopwords/stopwords.txt");
        WordCounter wordCounter = new WordCounter(stopWordsFilter);

        UI ui = args.length > 0 ? new FileBasedUI(args[0]) : new CommandLineBasedUI();

        int count = wordCounter.count(ui.getInput());
        ui.writeResults(count);
    }
}
