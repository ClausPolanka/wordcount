package wordcount;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterApplicationTest {
    @Test
    void runWithoutArgument() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader("abc the"));
        StringWriter writer = new StringWriter();
        BufferedWriter bufWriter = new BufferedWriter(writer);

        StopwordsProvider stopwordsProvider = getStopWordsProvider();

        WordCounterApplication app = new WordCounterApplication(reader, bufWriter, stopwordsProvider);

        //when
        app.run(new String[]{});

        //then
        bufWriter.flush();

        assertEquals("Number of words: 1", writer.toString());

    }

    @Test
    void runWithFileArgument() throws IOException {
        BufferedReader reader = new BufferedReader(new StringReader("abc the"));
        StringWriter writer = new StringWriter();
        BufferedWriter bufWriter = new BufferedWriter(writer);


        WordCounterApplication app = new WordCounterApplication(
                 reader, bufWriter, getStopWordsProvider());

        //when
        app.run(new String[]{"input.txt"});

        //then
        bufWriter.flush();

        assertEquals("Number of words: 3", writer.toString());

    }

    private ClasspathStopwordsProvider getStopWordsProvider() {
        return new ClasspathStopwordsProvider("stopwords.txt");
    }

}