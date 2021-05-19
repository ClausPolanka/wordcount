package wordcounter.userinterface;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UserInterfaceHandlerConsole extends UserInterfaceHandler {

    public UserInterfaceHandlerConsole(InputStream inputStream, OutputStream outputStream) {
        super(inputStream, outputStream);
    }

    @Override
    public String getInput() {
        Scanner input = new Scanner(getInputStream());
        try {
            getOutputStream().write("Enter text: ".getBytes(StandardCharsets.UTF_8));
        } catch (IOException ignored) {
        }
        return input.nextLine();
    }

}
