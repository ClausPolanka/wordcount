package com.wordcount;

import java.util.Scanner;

public class WorkCounterApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WordCounterUI wordCounterUI = new WordCounterUI(new WordCounter(), new SystemOutOutputInterface(), scanner::nextLine);
        wordCounterUI.countWords();
    }
}
