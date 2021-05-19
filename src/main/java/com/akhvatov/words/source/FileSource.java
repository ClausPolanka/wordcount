package com.akhvatov.words.source;

import java.util.stream.Stream;

public class FileSource implements Source {

    private final String fileName;

    public FileSource(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Stream<String> read() {
        return FileStreamProvider.from(fileName);
    }
}
