package wordcount.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserInterActor {

    private final Scanner scanner;
    private final BufferedWriter bufferedWriter;

    public UserInterActor(Scanner scanner, BufferedWriter bufferedWriter) {
        this.scanner = scanner;
        this.bufferedWriter = bufferedWriter;
    }

    public String read(String message) throws IOException {
        bufferedWriter.write(message);
        bufferedWriter.flush();

        return scanner.nextLine();
    }

    public void write(String message, long count) {

    }

}
