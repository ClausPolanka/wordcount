package com.ableneo.erste.wordcount.ui;

import java.io.IOException;
import java.io.InputStream;

public interface UI {
    InputStream getInput() throws IOException;

    void writeResults(int count);
}
