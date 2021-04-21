package stopwords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class StopWordsFileLoader implements StopWordsLoader {

    private final String filename;

    public StopWordsFileLoader(final String filename) {
        this.filename = filename;
    }

    @Override
    public Set<String> loadStopWords() {
        Set<String> words = new HashSet();
        final ClassLoader classLoader = getClass().getClassLoader();

        final URL stopwordsFileresource = classLoader.getResource(filename);
        if (stopwordsFileresource == null) {
            return null;
        }

        final File stopwordsFile = new File(stopwordsFileresource.getFile());

        final BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(stopwordsFile));
            String line = reader.readLine();
            while (line != null) {
                if (!line.trim().isEmpty()) {
                    words.add(line);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            return null;
        }

        return null;
    }
}
