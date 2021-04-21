package ui;

import stats.WordsStats;

import java.io.InputStream;

public interface UserInterface {

    InputStream getUserInput();

    void askForInput();

    void printStats(WordsStats wordsStats);
}
