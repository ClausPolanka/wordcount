package com.wordcount.ui;

public class UserInputFileTestFixtures {
    private static final String TEST_RESOURCES_EXAMPLE_TXT = "src/test/resources/example.txt";
    static final String EXAMPLE_FILE_CONTENT = "Mary had\na little\nlamb";

    static UserInputFileInterface createFromExampleFile() {
        return new UserInputFileInterface(TEST_RESOURCES_EXAMPLE_TXT);
    }
}
