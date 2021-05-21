package com.wordcount.ui;

import org.junit.jupiter.api.Test;

import static com.wordcount.ui.UserInputFileTestFixtures.EXAMPLE_FILE_CONTENT;
import static org.junit.jupiter.api.Assertions.*;

class UserInputFileInterfaceTest {

    @Test
    public void thatUserInputFileCanBeLoaded() {
        UserInputFileInterface userInputFileInterface = UserInputFileTestFixtures.createFromExampleFile();
        assertEquals(EXAMPLE_FILE_CONTENT, userInputFileInterface.getInput());
    }

    @Test
    public void thatUserFileCannotBeLoadedWithIncorrectPath() {
        UserInputFileInterface userInputFileInterface = new UserInputFileInterface("src/test/resources/incorrect_file.txt");
        assertThrows(IllegalArgumentException.class, userInputFileInterface::getInput);
    }
}