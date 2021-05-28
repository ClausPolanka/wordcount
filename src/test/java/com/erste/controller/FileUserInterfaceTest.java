package com.erste.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileUserInterfaceTest {

    UserInterface userInterface = new FileUserInterface("mytext.txt");

    @Test
    public void readFromFileWithFileUserInterface() {
        String expectedInputFromFile = "Mary had a little lamb";
        String fileInput = userInterface.getInput();
        assertTrue(fileInput.contains(expectedInputFromFile));
    }
}
