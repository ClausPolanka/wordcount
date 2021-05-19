package wordcounter.userinterface;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UserInterface {

    private InputStream inputStream;
    private OutputStream outputStream;

    public UserInterface(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public String getInput() {
        Scanner myObj = new Scanner(inputStream);
        try {
            outputStream.write("Enter text: ".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myObj.nextLine();
    }

    public void showOutput(int output) {
        String data = "Number of words: " + output;
        try {
            outputStream.write(data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
