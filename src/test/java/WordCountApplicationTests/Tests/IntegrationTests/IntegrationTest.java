package WordCountApplicationTests.Tests.IntegrationTests;

import WordCountApplication.View.WordCounterConsoleView;
import WordCountApplication.WordCountConsoleApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class IntegrationTest {

    private String fileAskMessageToUser = "Please add the name of a file to count the words of the file! (Press enter to skip it)";
    private String initialMessageToUser = "Please give words to count (Press enter(s) to start the counting):";
    private String[] testArgs = new String[]{"Integration test"};
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
    void isApplicationWorkingWithSingleLineConsoleInput() {
        // given
        String input = "\nTest String\n\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        WordCountConsoleApplication.main(testArgs);

        // then
        assertEquals(fileAskMessageToUser + endOfLineSeparatorForWindows + initialMessageToUser + endOfLineSeparatorForWindows + "Number of words: 2" + endOfLineSeparatorForWindows, byteArrayOfStream.toString());
    }

    @Test
    void isApplicationWorkingWithMultipleLineConsoleInput() {
        // given
        String input = "\nTest S2ring\n Dummy text with forbi!den cha!s\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        WordCountConsoleApplication.main(testArgs);

        // then
        assertEquals(fileAskMessageToUser + endOfLineSeparatorForWindows + initialMessageToUser + endOfLineSeparatorForWindows + "Number of words: 4" + endOfLineSeparatorForWindows, byteArrayOfStream.toString());
    }

    @Test
    void isApplicationWorkingWithSingleLineConsoleInputWithStopWords() {
        // given
        String input = "\nthe Test String\n\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        WordCountConsoleApplication.main(testArgs);

        // then
        assertEquals(fileAskMessageToUser + endOfLineSeparatorForWindows + initialMessageToUser + endOfLineSeparatorForWindows + "Number of words: 2" + endOfLineSeparatorForWindows, byteArrayOfStream.toString());
    }

    @Test
    void isApplicationWorkingWithMultipleLineConsoleInputWithStopWords() {
        // given
        String input = "\nthe Test S2ring\n a Dummy text with forbi!den cha!s\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        WordCountConsoleApplication.main(testArgs);

        // then
        assertEquals(fileAskMessageToUser + endOfLineSeparatorForWindows + initialMessageToUser + endOfLineSeparatorForWindows + "Number of words: 4" + endOfLineSeparatorForWindows, byteArrayOfStream.toString());
    }

    @Test
    void isApplicationWorkingWithMultipleLineFileInputWithStopWords() {
        // given
        String input = "mytext.txt\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // when
        WordCountConsoleApplication.main(testArgs);

        // then
        assertEquals(fileAskMessageToUser + endOfLineSeparatorForWindows + "Number of words: 4" + endOfLineSeparatorForWindows, byteArrayOfStream.toString());
    }
}
