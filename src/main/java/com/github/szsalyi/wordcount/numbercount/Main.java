package com.github.szsalyi.wordcount.numbercount;

import com.github.szsalyi.wordcount.io.ConsoleUserInput;

public class Main {
    public static void main(String[] args) {
        UserIO userIO = new ConsoleUserInput();
        WordProcessor wordProcessor = new WordProcessor(userIO);

        wordProcessor.count();
    }
}
