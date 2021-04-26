package chrapusta.tomasz.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class FileStructureRepository implements StopWordsRepository {

    @Override
    public Set<String> getStopWords() throws IOException, URISyntaxException {
        return new HashSet<>(
                Files.readAllLines(Paths.get(getResource().toURI())));
    }

    private URL getResource() throws FileNotFoundException {
        URL url = getClass().getResource("/stopwords.txt");
        if (url == null) {
            throw new FileNotFoundException("Provided url is null. Please check the url.");
        }
        return url;
    }


}
