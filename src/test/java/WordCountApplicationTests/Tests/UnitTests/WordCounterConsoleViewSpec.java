package WordCountApplicationTests.Tests.UnitTests;

import WordCountApplication.View.WordCounterConsoleView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterConsoleViewSpec {

    private WordCounterConsoleView consoleView;
    private ByteArrayOutputStream byteArrayOfStream;
    private PrintStream newPrintStream;
    private PrintStream oldPrintStream;
    private static String endOfLineSeparatorForWindows = "\r\n";


    @BeforeEach
    void initOutPutStream() {
        byteArrayOfStream = new ByteArrayOutputStream();
        newPrintStream = new PrintStream(byteArrayOfStream);
        oldPrintStream = System.out;
        System.setOut(newPrintStream);
    }

    @AfterEach
    void setBackDefaultStream() {
        System.out.flush();
        System.setOut(oldPrintStream);
    }

    @Test
    void canDisplayGivenMessage(){
        // given
        String testMessage = "Test message";
        consoleView = new WordCounterConsoleView();

        // when
        consoleView.updateView(testMessage);

        // then
        assertEquals(testMessage + endOfLineSeparatorForWindows, byteArrayOfStream.toString());
    }
}
