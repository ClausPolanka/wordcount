package wordcount.iter1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UncheckedIOException;

public class Application {
    public static void main(String[] args) {
        try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out))) {

            ResponseBuilder responseBuilder = new ResponseBuilder();
            ConsoleInteractor consoleInteractor = new ConsoleInteractor(
                    in,
                    out
            );
            WordCounter wordCounter = new WordCounter();

            String inputLine = consoleInteractor.read();

            long count = wordCounter.count(inputLine);

            consoleInteractor.write(responseBuilder.createOutputMessage(count));

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

}
