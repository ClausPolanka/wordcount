package sk.sloboda.wordcount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import sk.sloboda.wordcount.common.ArgumentHelper;

public class ArgumentHelperTest {

    private static ArgumentHelper helper;

    @BeforeAll
    public static void init() {
        helper = new ArgumentHelper();
    }

    @Test
    public void testInvalidFileName() {
        Assertions.assertFalse(helper.isFileNameEntered("notExistingFile.xtx"));
    }

    @Test
    public void testValidFileName() {
        Assertions.assertTrue(helper.isFileNameEntered("mytext.txt"));
        Assertions.assertEquals("Mary had a little lamb", helper.loadTextFromFile());
    }
}
