package wordcount;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterApplicationTest {
    @Test
    void run() throws IOException {
        StringReader reader = new StringReader("ABC the");
        StringWriter writer = new StringWriter();
        BufferedWriter bufWriter = new BufferedWriter(writer);

        ConsoleInteractor interactor = new ConsoleInteractor(
                new BufferedReader(reader),
                bufWriter);

        StopwordsProvider stopwordsProvider = () -> {
            Set<String> result = new HashSet<>();
            result.add("the");
            return result;
        };

        WordCounterApplication app = new WordCounterApplication(
            interactor, stopwordsProvider
        );


        //when
        app.run();

        //then

        bufWriter.flush();

        assertEquals("Number of words: 1", writer.toString());

    }


}