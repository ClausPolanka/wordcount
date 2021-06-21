package wordcount.io;

import wordcount.error.WrappedException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextReader implements ITextReader {
    InputStreamReader is;


    public TextReader(InputStreamReader is) {
        this.is = is;

        if (is == null) {
            throw new WrappedException(ErrorCode.TEXT_INPUT_IS_NULL.name());
        }

    }

    public String readText() {
        String result;

        try (BufferedReader reader =
                     new BufferedReader(is)) {

            result = reader.readLine();


        } catch (IOException ex) {
            throw new WrappedException(ErrorCode.READ_TEXT_ERROR, ex);
        }

        return result;
    }

}
