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
    public void displayOutput(int count) {
        System.out.println("Number of words: " + count);
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

}
