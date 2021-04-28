package hiring.wordcount.service.impl;

import hiring.wordcount.service.InputReaderService;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.InvalidParameterException;
import java.util.Scanner;

public class FileInputService implements InputReaderService {
    @Override
    public String getServiceName() {
        return "FileInputService";
    }

    @Override
    public String read(String path) throws Exception {
        if (path == null || path.isEmpty())
            throw new InvalidParameterException("Path cannot be null or empty");

        File file = new File(path);
        if (!file.exists())
            throw new FileNotFoundException(path);

        StringBuilder result = new StringBuilder();

        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            result.append(scanner.next()).append(" ");
        }
        scanner.close();

        return result.toString();
    }
}
