package wordcount.iter1;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Set;


class WordCounterApplicationTest {
    @Test
    void run() {
        StringReader reader = new StringReader("Mary_Mery");
        StringWriter writer = new StringWriter(1);

        ConsoleInteractor interactor = new ConsoleInteractor(
                new BufferedReader(reader),
                new BufferedWriter(writer));

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

        String out = writer.getBuffer().toString();
    }


}