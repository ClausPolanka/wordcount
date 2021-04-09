package testUtil;

import io.UserInterface;

import java.io.OutputStream;
import java.io.PrintStream;

public class MockIO implements UserInterface {

    String inputString;

    @Override
    public String getInput(){
        return this.inputString;
    }

    @Override
    public void displayOutput(int count, int uniqueCount) {

        final String output = String.format("Number of words: %d, unique:%d", count, uniqueCount);
        System.out.println(output);
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

}
