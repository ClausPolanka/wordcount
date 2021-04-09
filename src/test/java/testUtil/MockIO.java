package testUtil;

import io.InputOutputInterface;

import java.io.IOException;

public class MockIO implements InputOutputInterface {

    String inputString;

    @Override
    public String getInput() throws IOException {
        return this.inputString;
    }

    @Override
    public String displayOutput(String outputString) {
        return "Number of words: " + outputString;
    }

    public void setInputString(String inputString) {

        this.inputString = inputString;

    }
}
