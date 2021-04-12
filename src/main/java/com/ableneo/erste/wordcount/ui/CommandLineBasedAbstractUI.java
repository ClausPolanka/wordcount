package com.ableneo.erste.wordcount.ui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class CommandLineBasedAbstractUI extends AbstractUI {

    @Override
    public InputStream getInput() {
        System.out.print("Enter text: ");
        return new ByteArrayInputStream(new Scanner(System.in).nextLine().getBytes());
    }
}
