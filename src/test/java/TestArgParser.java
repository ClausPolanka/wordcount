import org.junit.jupiter.api.Test;
import root.wordcounter.ArgParser;
import root.wordcounter.data.Args;

import static org.junit.jupiter.api.Assertions.*;

public class TestArgParser {

    @Test
    public void okNoArgs() {
        Args parsedArgs = ArgParser.parseArgs(new String[]{});

        assertNull(parsedArgs.getFilename());
        assertFalse(parsedArgs.printIndex());
    }

    @Test
    public void okIndexArg() {
        Args parsedArgs = ArgParser.parseArgs(new String[]{"-index"});

        assertNull(parsedArgs.getFilename());
        assertTrue(parsedArgs.printIndex());
    }

    @Test
    public void okIndexAndFilenameArg() {
        Args parsedArgs = ArgParser.parseArgs(new String[]{"filename.txt", "-index"});

        assertEquals("filename.txt", parsedArgs.getFilename());
        assertTrue(parsedArgs.printIndex());
    }

}
