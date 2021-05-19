package wordcounter.userinterface;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public abstract class UserInterfaceHandler {

    private InputStream inputStream;
    private OutputStream outputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public UserInterfaceHandler(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public abstract String getInput();

    public void showOutput(int output) {
        String data = "Number of words: " + output;
        try {
            outputStream.write(data.getBytes(StandardCharsets.UTF_8));
        } catch (IOException ignored) {
        }
    }
}
