package at.erste.boskovic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationIT {

    @Test
    void shouldCountCorrectNumberForFileWithStopwords(){
        Application application = new Application();
        String[] args = {"input_test_files/test_input.txt"};

        assertEquals(4, application.countWordsFromInput(args));
    }

}