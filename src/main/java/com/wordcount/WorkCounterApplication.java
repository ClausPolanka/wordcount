package com.wordcount;

public class WorkCounterApplication {

    public static void main(String[] args) {
        WordCounterUI wordCounterUI = new WordCounterUI(new WordCounter(), new SystemOutOutputInterface(), new ScannerInputInterface());
        wordCounterUI.countWords();
    }
}
