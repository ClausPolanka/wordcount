package WordCountApplicationTests.Tests.UnitTests;

import WordCountApplication.Helpers.IOWorker;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IOWorkerSpec {

    private IOWorker worker;

    @Test
    void canReadSimpleLine() {
        // given
        String input = "Test String\n\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        worker = new IOWorker(scanner);

        // when
        List<String> result = worker.readFromConsole();

        // then
        assertEquals(new ArrayList<String>(){{add("Test String");}}, result);
    }

    @Test
    void canReadMultipleLine() {
        // given
        String input = "Test String\nTest String 2nd Line\n\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        worker = new IOWorker(scanner);

        // when
        List<String> result = worker.readFromConsole();

        // then
        assertEquals(new ArrayList<String>(){{add("Test String"); add("Test String 2nd Line");}}, result);
    }
}
