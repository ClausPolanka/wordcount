package com.wordcount.ui;

import java.util.Scanner;

public class ScannerInputInterface implements InputInterface {

    public static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public String getInput() {
        return SCANNER.nextLine();
    }

    @Override
    public InputType getInputType() {
        return InputType.MANUAL;
    }
}
