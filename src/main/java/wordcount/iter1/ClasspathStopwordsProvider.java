package wordcount.iter1;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ClasspathStopwordsProvider implements StopwordsProvider {
    private final String fileName;

    /**
     * @param fileName expected to be in the root.
     */
    public ClasspathStopwordsProvider(String fileName) {

        this.fileName = Objects.requireNonNull(fileName, "filename cannot be null");
    }

    public Set<String> getStopWords() {

        URL resource = this.getClass().getResource(fileName.startsWith("/") ? fileName : "/" + fileName);
        try {
            List<String> content = Files.readAllLines(Paths.get(resource.getFile()));
            return new HashSet<>(content);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }

    }
}
