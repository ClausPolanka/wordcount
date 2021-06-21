package utils;

import wordcount.error.WrappedException;
import wordcount.io.ErrorCode;
import wordcount.io.StopWordReader;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Optional;

public class ResourceFetcher {

    public File getFileFromResources(Optional<String> fileName, ErrorCode code) {
        URL resource = StopWordReader.class.getClassLoader().getResource(fileName.get());
        File file;
        try {
            file = Paths.get(resource.toURI()).toFile();

        }
        catch(URISyntaxException ex) {
            throw new WrappedException(code.name());
        }
        return file;
    }

}
