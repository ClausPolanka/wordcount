package wordcount.io;

import org.junit.jupiter.api.Test;
import wordcount.mocks.TestFileReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class StopWordsReaderTest {

    public static final Optional<String> EMPTY = Optional.of("");
    private StopWordsReader sut;

    @Test
    void should_Read_Split_Content_Line_By_Line() throws IOException {
        FileReader fileReader = new TestFileReader(Optional.of("the\na\non\noff\n"));
        sut = new StopWordsReader(fileReader);

        List<String> actual = sut.read("fileName");

        assertEquals(asList("the", "a", "on", "off"), actual);
    }

    @Test
    void should_Read_Empty_File_Content() throws IOException {
        FileReader fileReader = new TestFileReader(EMPTY);
        sut = new StopWordsReader(fileReader);

        List<String> actual = sut.read("fileName");

        assertEquals(Collections.emptyList(), actual);
    }

    @Test
    void should_Read_Return_Empty_List_When_File_Not_Provided() throws IOException {
        FileReader fileReader = new TestFileReader(Optional.empty());
        sut = new StopWordsReader(fileReader);

        List<String> actual = sut.read("fileName");

        assertEquals(Collections.emptyList(), actual);
    }
}