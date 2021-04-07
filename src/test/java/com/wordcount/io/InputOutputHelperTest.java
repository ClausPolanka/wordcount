package com.wordcount.io;

import com.wordcount.filter.StopwordFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputOutputHelperTest {

    InputOutputHelper inputOutputHelper;

    @BeforeEach
    public void setup() {
        inputOutputHelper = new InputOutputHelper();
    }

    @Test
    void readFromFile() {
        System.out.println(inputOutputHelper.readFromFile("mytext.txt"));
    }

    @Test
    void readFromCommandline() {
    }
}