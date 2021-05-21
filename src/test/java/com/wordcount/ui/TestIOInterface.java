package com.wordcount.ui;

public class TestIOInterface implements InputInterface, OutputInterface {

    private final StringBuilder sb = new StringBuilder();
    private final String userInput;
    private final InputType inputType;

    public TestIOInterface(String userInput, InputType inputType) {
        this.userInput = userInput;
        this.inputType = inputType;
    }

    @Override
    public void print(String text) {
        sb.append(text);
    }

    @Override
    public void println(String text) {
        sb.append(text).append("\n");
    }

    @Override
    public String getInput() {
        sb.append(userInput).append("\n");
        return userInput;
    }

    public String getOutput() {
        return sb.toString();
    }

    @Override
    public InputType getInputType() {
        return inputType;
    }
}
