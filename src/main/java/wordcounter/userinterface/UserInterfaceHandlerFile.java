package wordcounter.userinterface;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class UserInterfaceHandlerFile extends UserInterfaceHandler {

    public UserInterfaceHandlerFile(InputStream inputStream, OutputStream outputStream) {
        super(inputStream, outputStream);
    }

    @Override
    public String getInput() {
        Scanner input = new Scanner(getInputStream());
        List<String> words = new ArrayList<>();
        StringJoiner stringJoiner = new StringJoiner(" ");
        while (input.hasNextLine()) {
            words.add(input.next());
        }
        words.forEach(stringJoiner::add);
        return stringJoiner.toString();
    }
}
