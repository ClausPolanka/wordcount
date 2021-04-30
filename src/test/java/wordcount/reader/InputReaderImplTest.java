package wordcount.reader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderImplTest {

    private static final String TEST_FILE_LOCATION = "src/test/resources/in.txt";

    private FileOutputStream fileOutputStream;
    private FileInputStream fileInputStream;

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
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        new PrintWriter(TEST_FILE_LOCATION).close();
    }


    @Test
    void readLine() throws IOException {
        //arrange
        String testString = "Hello world";
        fileOutputStream.write(testString.getBytes(StandardCharsets.UTF_8));
        fileOutputStream.flush();

        fileInputStream = new FileInputStream(new File(TEST_FILE_LOCATION));
        InputReaderImpl inputReader = new InputReaderImpl(fileInputStream);

        //act
        String actualString = inputReader.readLine();

        //assert
        assertEquals(testString, actualString);
    }

}
