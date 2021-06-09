import org.junit.jupiter.api.Test;
import root.service.StopWordsProviderInterface;
import root.service.impl.FileStopWordsProvider;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileStopWordsProviderTest {

    @Test
    public void okCorrectLineRed() {
        StopWordsProviderInterface stopWordsProvider = new FileStopWordsProvider();
        Set<String> expected = new HashSet<>(Arrays.asList("the", "a", "on", "off"));
        
        assertEquals(expected, stopWordsProvider.getStopWords());
    }

}
