package com.wordcount.ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputInterfaceFactoryTest {

    @Test
    public void thatWithProvidedArgumentTheUserInputFileInterfaceIsCreated() {
        InputInterface inputInterface = InputInterfaceFactory.create(new String[]{"some_file.txt"});
        assertTrue(inputInterface instanceof UserInputFileInterface);
    }

    @Test
    public void thatWithNotProvidedArgumentTheScannerInputInterfaceIsCreated() {
        InputInterface inputInterface = InputInterfaceFactory.create(new String[]{});
        assertTrue(inputInterface instanceof ScannerInputInterface);
    }

}