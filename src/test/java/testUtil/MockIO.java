package testUtil;

import io.UserInterface;
import model.WordDetailsDTO;

import java.io.OutputStream;
import java.io.PrintStream;

public class MockIO implements UserInterface {

    String inputString;

    @Override
    public String getInput(){
        return this.inputString;
    }

    @Override
    public void displayOutput(WordDetailsDTO wordDetailsDTO) {

        final String output = String.format("Number of words: %d, unique:%d;  average word length: %d characters",
                wordDetailsDTO.getCount(), wordDetailsDTO.getUniqueCount(), wordDetailsDTO.getAverageLength());
        System.out.println(output);

    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

}
