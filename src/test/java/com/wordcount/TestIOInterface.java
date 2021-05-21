package com.wordcount;

public class TestIOInterface implements InputInterface, OutputInterface {

    private final StringBuilder sb = new StringBuilder();
    private final String userInput;

    public TestIOInterface(String userInput) {
        this.userInput = userInput;
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
}
