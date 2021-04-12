package com.ableneo.erste.wordcount.ui;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileBasedAbstractUITest {

    @Test
    void readFile() throws IOException {
        String file = this.getClass().getClassLoader().getResource("mytext.txt").getPath();
        FileBasedAbstractUI fileBasedUI = new FileBasedAbstractUI(file);

        String fileContent = new BufferedReader(new InputStreamReader(fileBasedUI.getInput(), StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));

        assertEquals("Mary had\na little\nlamb", fileContent);
    }
}
