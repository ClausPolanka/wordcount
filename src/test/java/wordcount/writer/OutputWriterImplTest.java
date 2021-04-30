package wordcount.writer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

class OutputWriterImplTest {

    private static final String TEST_FILE_LOCATION = "src/test/resources/out.txt";

    private FileOutputStream fileOutputStream;
    private BufferedReader reader;

    @BeforeEach
    public void initEach() throws FileNotFoundException {
        new PrintWriter(TEST_FILE_LOCATION).close();
        fileOutputStream = new FileOutputStream(TEST_FILE_LOCATION);
    }

    @AfterEach
    public void afterEach() throws IOException {
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        if (reader != null) {
            reader.close();
        }
        new PrintWriter(TEST_FILE_LOCATION).close();
    }

    @Test
    void writeResult() throws IOException {
        //arrange
        OutputWriterImpl outputWriter = new OutputWriterImpl(fileOutputStream);
        BufferedReader reader = new BufferedReader(new FileReader(TEST_FILE_LOCATION));
        String output = "Hello";

        //act
        outputWriter.writeResult(output);

        //assert
        Assertions.assertEquals(output, reader.readLine());
    }

}
