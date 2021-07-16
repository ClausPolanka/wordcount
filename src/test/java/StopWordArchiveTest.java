import com.wordcount.StopWordArchive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StopWordArchiveTest {

    private static final String PATH_STOP_WORD = "src/resources/stopwords.txt";
    StopWordArchive stopWordArchive;

    @BeforeEach
    public void init()  {
        stopWordArchive = new StopWordArchive();
    }

    @Test
    public void getExcludeWords_Size_Test()   {
        Assertions.assertEquals(4,stopWordArchive.getAllWords(PATH_STOP_WORD).size());
        Assertions.assertTrue(stopWordArchive.getAllWords(PATH_STOP_WORD).contains("off"));
    }

    @Test
    public void getExcludeWords_Content_Test()   {
        Assertions.assertTrue(stopWordArchive.getAllWords(PATH_STOP_WORD).contains("off"));
        Assertions.assertFalse(stopWordArchive.getAllWords(PATH_STOP_WORD).contains("car"));
    }


}
