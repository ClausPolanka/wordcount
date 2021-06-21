package wordcount.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class TextReader implements ITextReader {
    InputStreamReader is;


    public TextReader(InputStreamReader is) {
       this.is = is;
    }

    public String readText() {
        String result;

        try (BufferedReader reader =
                     new BufferedReader(is)) {

            result = reader.readLine();


        } catch(IOException | NullPointerException ex) {
            throw new WrappedException(Errors.READ_TEXT_ERROR, ex);
        }

        return result;
    }

}
