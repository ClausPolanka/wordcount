package wordcount.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

public class FileReader {

    public Optional<String> read(String fileName) throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(fileName);
        if (inputStream == null) {
            return Optional.empty();
        }
        return readFromInputStream(inputStream);
    }

    private Optional<String> readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return Optional.of(resultStringBuilder.toString());
    }
}
