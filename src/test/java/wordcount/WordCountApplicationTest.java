package wordcount;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wordcount.reader.InputReaderImpl;
import wordcount.writer.OutputWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCountApplicationTest {

    private static final String TEST_FILE_LOCATION = "src/test/resources/in.txt";

    //For writing test strings
    private FileOutputStream fileOutputStream;

    //Input stream used for test
    private FileInputStream fileInputStream;

    @BeforeEach
    public void initEach() throws FileNotFoundException {
        //in order to delete content
        new PrintWriter(TEST_FILE_LOCATION).close();
        fileOutputStream = new FileOutputStream(TEST_FILE_LOCATION);
    }

    @AfterEach
    public void afterEach() throws IOException {
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        //in order to delete content
        new PrintWriter(TEST_FILE_LOCATION).close();
    }


    @Test
    void wordCountApplication() throws IOException {
        //arrange
        String testString = "Hello, magic JAVA world!";
        fileOutputStream.write(testString.getBytes(StandardCharsets.UTF_8)); //write test string
        fileOutputStream.flush();

        fileInputStream = new FileInputStream(new File(TEST_FILE_LOCATION));
        InputReaderImpl inputReader = new InputReaderImpl(fileInputStream); //creating input reader with file stream

        MockOutputWriter outputWriter = new MockOutputWriter();

        //act
        new WordCountApplication(inputReader, outputWriter);

        //assert
        assertEquals("Number of words: 2", outputWriter.getOutput());
    }

    private final class MockOutputWriter implements OutputWriter{

        private String output;

        String getOutput(){
            return output;
        }

        @Override
        public void writeResult(String output) throws IOException {
            this.output = output;
        }

    }

}
