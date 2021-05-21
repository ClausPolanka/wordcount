package com.wordcount;

import java.util.Scanner;

public class ScannerInputInterface implements InputInterface {

    public static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public String getInput() {
        return SCANNER.nextLine();
    }
}
