package com.oscerba.george.config;

import com.oscerba.george.processor.WordProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class ApplicationConfigParserTest {

    @Test
    public void testIndexConfig() {
        String[] args = {"-index"};
        ApplicationConfig applicationConfig = new ApplicationConfigParser().parse(args);

        Assertions.assertTrue(applicationConfig.isIndexEnabled());
    }

    @Test
    public void testWordsFileInputConfig() {
        String[] args = {"inputFile.txt"};
        ApplicationConfig applicationConfig = new ApplicationConfigParser().parse(args);

        Assertions.assertEquals(Paths.get("inputFile.txt"), applicationConfig.getWordsInputFilePath());
    }

}
