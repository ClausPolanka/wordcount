package com.erste;

import com.erste.controller.StandardInAndOutputUserInterface;
import com.erste.controller.UserInterface;
import com.erste.service.WordCountManager;

public class WordCounterApplication {
    public static void main(String[] args) {
        WordCountManager wordCountManager = new WordCountManager();
        UserInterface userInterface = new StandardInAndOutputUserInterface(wordCountManager);

    }
}
