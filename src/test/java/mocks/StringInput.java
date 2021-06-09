package mocks;

import root.wordcounter.InputInterface;

public class StringInput implements InputInterface {

    private String input;

    public StringInput(String input) {
        this.input = input;
    }

    @Override
    public String getInput() {
        return input;
    }
}
