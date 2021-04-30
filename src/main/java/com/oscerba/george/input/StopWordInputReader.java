package com.oscerba.george.input;

import java.io.IOException;
import java.util.List;

public abstract class StopWordInputReader {
    public abstract List<String> getStopWords() throws IOException;
}
