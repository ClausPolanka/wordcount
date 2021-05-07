package wordcount.iter1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UncheckedIOException;

public class Application {
    public static void main(String[] args) {
        try(InputStreamReader in = new InputStreamReader(System.in);
                OutputStreamWriter out = new OutputStreamWriter(System.out)) {

            ConsoleInteractor consoleInteractor = new ConsoleInteractor(
                    in,
                    out
            );
            WordCounter wordCounter = new WordCounter();

            String inputLine = consoleInteractor.read();


            long count = wordCounter.count(inputLine);

            consoleInteractor.write(String.valueOf(count));

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
