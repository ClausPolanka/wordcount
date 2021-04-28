package hiring.wordcount.service.impl;

import hiring.wordcount.service.InputReaderService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StandardIOService implements InputReaderService {
    @Override
    public String getServiceName() {
        return "StandardIOService";
    }

    @Override
    public String read(String path) throws IOException {
        // Enter data using BufferReader
        System.out.print("Enter text: ");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        // Reading data using readLine
        String line = reader.readLine();

        return line;
    }
}
