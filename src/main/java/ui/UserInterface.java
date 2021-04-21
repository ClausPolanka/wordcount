package ui;

import java.io.InputStream;

public interface UserInterface {

    InputStream getUserInput();

    void printWordsCount(int wordCount);
}
