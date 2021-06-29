import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

public class WordCountTests {

    private WordCount wordCount;

    private static final String TEXT = "Mary had a little lamb";

    private static final String NON_TEXT = "Mary had a, little-lamb";

    private static final String TWO_SPACES_TEXT = "Mary  had  a  little  lamb";

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
        Assert.assertEquals(3, this.wordCount.getNumberOfWords(TEXT, true));
    }

    @Test
    public void checkTextWithNonWordsAndExcludedWords() throws FileNotFoundException, FormatException {
        Assert.assertEquals(1, this.wordCount.getNumberOfWords(NON_TEXT, true));
    }

    @Test
    public void checkWhenTextHasTwoSpacesAndExcludedWords() throws FileNotFoundException, FormatException {
        Assert.assertEquals(3, this.wordCount.getNumberOfWords(TWO_SPACES_TEXT, true));
    }
}
