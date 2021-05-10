package at.erste.boskovic.ui;

import at.erste.boskovic.InputTextReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileInputTextReaderTest {

    @Test
    void shouldReadCorrectInput(){
        String testFile = "input_test_files/test_input.txt";
        String expectedInput = "Mary test_had\ntest_a little\nlamb";
        InputTextReader inputTextReader = new FileInputTextReader(testFile);
        assertEquals(expectedInput, inputTextReader.readInput());
    }

}