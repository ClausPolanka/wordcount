package com.wordcount.ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInputFileInterfaceTest {
    private final static String EXPECTED_USER_INPUT = "Mary had\na little\nlamb";

    @Test
    public void thatUserInputFileCanBeLoaded() {
        UserInputFileInterface userInputFileInterface = new UserInputFileInterface("src/test/resources/mytext.txt");
        assertEquals(EXPECTED_USER_INPUT, userInputFileInterface.getInput());
    }

    @Test
    public void thatUserFileCannotBeLoadedWithIncorrectPath() {
        UserInputFileInterface userInputFileInterface = new UserInputFileInterface("src/test/resources/incorrect_file.txt");
        assertThrows(IllegalArgumentException.class, userInputFileInterface::getInput);
    }
}