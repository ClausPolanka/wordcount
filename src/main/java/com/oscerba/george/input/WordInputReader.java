package com.oscerba.george.input;

import java.io.IOException;
import java.util.List;

public abstract class WordInputReader {
    public abstract List<String> getWords() throws IOException;
}
