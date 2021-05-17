package wordcount.io;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class StopWordsReader {

    public static final String END_OF_LINE = "\n";
    public static final String WHITESPACES = "\\s*";
    private final FileReader fileReader;

    public StopWordsReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public List<String> read(String fileName) throws IOException {
        Optional<String> content = fileReader.read(fileName);
        if (content.isPresent()) {
            return splitContent(content.get());
        }
        return Collections.emptyList();
    }

    private List<String> splitContent(String content) {
        if (content.matches(WHITESPACES)) {
            return Collections.emptyList();
        }
        return Arrays.asList(content.split(END_OF_LINE));
    }
}
