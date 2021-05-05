package at.george;

import at.george.counter.StopwordsFilterDecorator;
import at.george.counter.TextSequenceCounter;
import at.george.io.ConsoleReader;
import at.george.io.ConsoleWriter;
import at.george.io.FileReader;
import at.george.io.ResourceBasedStopwordsProvider;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordCountRunnerEndToEndTests {

    @Test
    public void testWithInputFromConsole() {
        String input = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";

        InputStream stdin = System.in;
        PrintStream stdout = System.out;

        try {
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));
            System.setIn(new ByteArrayInputStream(input.getBytes()));

            WordCountConfiguration configuration = new WordCountConfiguration(
                    new ConsoleReader(),
                    new StopwordsFilterDecorator(new TextSequenceCounter(), new ResourceBasedStopwordsProvider()),
                    new ConsoleWriter()
            );

            new WordCountRunner().run(configuration);

            String out = outContent.toString().trim();
            assertTrue(out.contains("Number of words: 9"));
            assertTrue(out.contains("unique: 7"));
        } finally {
            System.setIn(stdin);
            System.setOut(stdout);
        }
    }

    @Test
    public void testWithInputFromFile() {
        PrintStream stdout = System.out;

        try {
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            WordCountConfiguration configuration = new WordCountConfiguration(
                    new FileReader(new String[]{"mytext.txt"}, new ConsoleReader()),
                    new StopwordsFilterDecorator(new TextSequenceCounter(), new ResourceBasedStopwordsProvider()),
                    new ConsoleWriter()
            );

            new WordCountRunner().run(configuration);

            String out = outContent.toString().trim();
            assertTrue(out.contains("Number of words: 5"));
            assertTrue(out.contains("unique: 4"));
        } finally {
            System.setOut(stdout);
        }
    }
}
