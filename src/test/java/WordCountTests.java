import exceptions.FormatException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class WordCountTests {

    private WordCount wordCount;

    private static final String TEXT = "Mary had a little lamb";

    private static final String NON_TEXT = "Mary had a, little-lamb";

    private static final String TWO_SPACES_TEXT = "Mary  had  a  little  lamb";

    private static final String NON_EXISTING_FILE = "file.txt";

    private static final String TEXT_FILE = "mytext.txt";

    private static final String WRONG_FILE_FORMAT = "file.jpg";

    @Before
    public void init(){
        this.wordCount = new WordCount();
    }

    @Test
    public void checkWhenTextIsNullShouldReturn0() throws FileNotFoundException, FormatException {
        Assert.assertEquals(0, this.wordCount.getNumberOfWords(null));
    }

    @Test
    public void checkWhenTextIsEmptyShouldReturn0() throws FileNotFoundException, FormatException {
        Assert.assertEquals(0, this.wordCount.getNumberOfWords(""));
    }

    @Test
    public void checkTextWithMultipleWords() throws FileNotFoundException, FormatException {
        Assert.assertEquals(5, this.wordCount.getNumberOfWords(TEXT));
    }

    @Test
    public void checkTextWithNonWords() throws FileNotFoundException, FormatException {
        Assert.assertEquals(2, this.wordCount.getNumberOfWords(NON_TEXT));
    }

    @Test
    public void checkWhenTextHasTwoSpaces() throws FileNotFoundException, FormatException {
        Assert.assertEquals(5, this.wordCount.getNumberOfWords(TWO_SPACES_TEXT));
    }

    @Test
    public void checkWhenTextIsNullWithExcludedWordsShouldReturn0() throws FileNotFoundException, FormatException {
        Assert.assertEquals(0, this.wordCount.getNumberOfWords(null, true));
    }

    @Test
    public void checkWhenTextIsEmptyWithExcludedWordsShouldReturn0() throws FileNotFoundException, FormatException {
        Assert.assertEquals(0, this.wordCount.getNumberOfWords("", true));
    }

    @Test
    public void checkTextWithMultipleWordsAndExcludedWords() throws FileNotFoundException, FormatException {
        Assert.assertEquals(4, this.wordCount.getNumberOfWords(TEXT, true));
    }

    @Test
    public void checkTextWithNonWordsAndExcludedWords() throws FileNotFoundException, FormatException {
        Assert.assertEquals(2, this.wordCount.getNumberOfWords(NON_TEXT, true));
    }

    @Test
    public void checkWhenTextHasTwoSpacesAndExcludedWords() throws FileNotFoundException, FormatException {
        Assert.assertEquals(4, this.wordCount.getNumberOfWords(TWO_SPACES_TEXT, true));
    }

    @Test (expected = FileNotFoundException.class)
    public void checkWithNullFileShouldThrowAnException() throws FileNotFoundException, FormatException {
        this.wordCount.getNumberOfWordsFromFile(null);
    }

    @Test (expected = FileNotFoundException.class)
    public void checkWithNonExistingFileShouldThrowAnException() throws FileNotFoundException, FormatException {
        this.wordCount.getNumberOfWordsFromFile(NON_EXISTING_FILE);
    }

    @Test (expected = FormatException.class)
    public void checkWithWrongFileFormatShouldThrowAnException() throws FileNotFoundException, FormatException {
        this.wordCount.getNumberOfWordsFromFile(WRONG_FILE_FORMAT);
    }

    @Test
    public void checkWithCorrectFile() throws FileNotFoundException, FormatException {
        Assert.assertEquals(4, this.wordCount.getNumberOfWordsFromFile(TEXT_FILE));
    }
}
