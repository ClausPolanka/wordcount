package mocks;

import root.service.WordInputInterface;

public class StringInput implements WordInputInterface {

    private String input;

    public StringInput(String input) {
        this.input = input;
    }

    @Override
    public String getInput() {
        return input;
    }
}
