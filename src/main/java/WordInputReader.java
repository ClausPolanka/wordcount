import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class WordInputReader {

    private Logger LOGGER = Logger.getLogger(WordInputReader.class.getName());

    public String readSystemInput() {
        System.out.print("Enter text: ");

        BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

        return readLine(reader);
    }

    private String readLine(BufferedReader reader){
        String inputText = null;

        try {
            inputText = reader.readLine();

        } catch (IOException e) {
            LOGGER.warning("Error occurred trying to read text input: "+ e.getMessage());
        }

        return inputText;
    }
}
