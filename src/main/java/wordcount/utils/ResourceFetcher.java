package wordcount.utils;

import wordcount.error.WrappedException;
import wordcount.io.ErrorCode;
import wordcount.io.StopwordReader;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class ResourceFetcher {

    public File getFileFromResources(String fileName, ErrorCode code) {
        File file;
        try {
            URL resource = StopwordReader.class.getClassLoader().getResource(fileName);
            file = Paths.get(resource.toURI()).toFile();

        } catch (URISyntaxException | NullPointerException ex) {
            throw new WrappedException(code.name());
        }
        return file;
    }

}
