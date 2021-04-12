package com.ableneo.erste.wordcount.ui;

import com.ableneo.erste.wordcount.counter.CounterResult;

import java.io.IOException;
import java.io.InputStream;

public interface UI {

    InputStream getInput() throws IOException;

    void writeResults(CounterResult count);
}
