package com.wordcount;

import com.wordcount.ui.ScannerInputInterface;
import com.wordcount.ui.SystemOutOutputInterface;
import com.wordcount.ui.WordCounterUI;

public class WorkCounterApplication {

    public static void main(String[] args) {
        WordCounterUI wordCounterUI = new WordCounterUI(new WordCounter(), new SystemOutOutputInterface(), new ScannerInputInterface());
        wordCounterUI.countWords();
    }
}
