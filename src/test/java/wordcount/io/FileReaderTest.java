package wordcount.io;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileReaderTest {

    private FileReader sut = new FileReader();


    @Test
    void should_Read_Provided_File() throws IOException {
        Optional<String> actual = sut.read("/stopwords.txt");

        assertEquals("the\na\non\noff\n", actual.get());
    }

    @Test
    void should_Read_Empty_File() throws IOException {
        Optional<String> actual = sut.read("/empty.txt");

        assertEquals("", actual.get());
    }

    @Test
    void should_Read_Return_Empty_When_File_Not_Exists() throws IOException {
        Optional<String> actual = sut.read("/not_existing.txt");

        assertEquals(Optional.empty(), actual);
    }
}