package com.wordcount;

import com.wordcount.ui.*;

public class WorkCounterApplication {

    public static void main(String[] args) {
        InputInterface inputInterface = InputInterfaceFactory.create(args);
        WordCounterUI wordCounterUI = new WordCounterUI(new WordCounter(new StopWordsReader()), new SystemOutOutputInterface(), inputInterface);
        wordCounterUI.countWords();
    }
}
