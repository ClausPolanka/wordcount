package wordcount.mocks;

import wordcount.io.FileReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public class TestFileReader extends FileReader {

    private final Optional<String> response;

    public TestFileReader(Optional<String> response) {
        this.response = response;
    }

    @Override
    public Optional<String> read(String fileName) {
        return response;
    }


}
