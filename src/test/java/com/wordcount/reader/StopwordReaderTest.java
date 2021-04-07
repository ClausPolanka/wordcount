package com.wordcount.reader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StopwordReaderTest {

    @Test
    void readStopwords() {
        StopwordReader reader = new StopwordReader();
        System.out.println(reader.blep().toString());
    }
}