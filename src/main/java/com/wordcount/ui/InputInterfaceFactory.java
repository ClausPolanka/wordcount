package com.wordcount.ui;

public class InputInterfaceFactory {

    public static InputInterface create(String[] args) {
        return args.length > 0 ? new UserInputFileInterface(args[0]) : new ScannerInputInterface();
    }
}
