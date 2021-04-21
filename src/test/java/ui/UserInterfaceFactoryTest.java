package ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UserInterfaceFactoryTest {

    @Test
    void whenNoFilenameIsProvidedThenFallbackToConsoleUserInterface() {
        UserInterface userInterface = UserInterfaceFactory.createUserInterface(null);
        assertTrue(userInterface instanceof ConsoleUserInterface);

        userInterface = UserInterfaceFactory.createUserInterface(new String[0]);
        assertTrue(userInterface instanceof ConsoleUserInterface);
    }


    @Test
    void whenFilenameIsProvidedThenInputFileUserInterfaceIsCreated() {
        String[] args = new String[1];
        args[0] = "inputfile.txt";

        UserInterface userInterface = UserInterfaceFactory.createUserInterface(args);
        assertTrue(userInterface instanceof InputFileUserInterface);
    }

}