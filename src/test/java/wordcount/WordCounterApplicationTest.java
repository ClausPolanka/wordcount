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
        StringReader reader = new StringReader("abc the");
        StringWriter writer = new StringWriter();
        BufferedWriter bufWriter = new BufferedWriter(writer);

        ConsoleInteractor interactor = new ConsoleInteractor(
                new BufferedReader(reader),
                bufWriter);

        StopwordsProvider stopwordsProvider = getStopWordsProvider();

        WordCounterApplication app = new WordCounterApplication(interactor,  stopwordsProvider);

        //when
        app.run(new String[]{});

        //then
        bufWriter.flush();

        assertEquals("Number of words: 1", writer.toString());

    }

    @Test
    void runWithFileArgument() throws IOException {
        StringReader reader = new StringReader("");
        StringWriter writer = new StringWriter();
        BufferedWriter bufWriter = new BufferedWriter(writer);

        ConsoleInteractor interactor = new ConsoleInteractor(
                new BufferedReader(reader),
                bufWriter);

        StopwordsProvider stopwordsProvider = getStopWordsProvider();

        WordCounterApplication app = new WordCounterApplication(
                interactor, getStopWordsProvider());

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