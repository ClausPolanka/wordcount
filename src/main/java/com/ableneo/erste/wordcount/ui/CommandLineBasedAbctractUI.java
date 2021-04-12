package com.ableneo.erste.wordcount.ui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class CommandLineBasedAbctractUI extends AbctractUI {

    @Override
    public InputStream getInput() {
        System.out.print("Enter text: ");
        return new ByteArrayInputStream(new Scanner(System.in).nextLine().getBytes());
    }
}
