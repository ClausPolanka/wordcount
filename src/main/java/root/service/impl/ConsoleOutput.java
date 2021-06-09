package root.service.impl;

import root.service.OutputInterface;

public class ConsoleOutput implements OutputInterface {

    @Override
    public void print(String text) {
        System.out.print(text);
    }
}
