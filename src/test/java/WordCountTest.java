import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordCountTest {

    private WordCount wordCount;
    private String text;

    @Before
    public void init(){
        this.wordCount = new WordCount();
    }

    @Test
    public void checkWhenTextIsNullShouldReturn0(){
        Assert.assertEquals(0, this.wordCount.getNumberOfWords(null));
    }

    @Test
    public void checkWhenTextIsEmptyShouldReturn0(){
        this.text = "";

        Assert.assertEquals(0, this.wordCount.getNumberOfWords(this.text));
    }

    @Test
    public void checkTextWithMultipleWords(){
        this.text = "Old McDonald had a farm";

        Assert.assertEquals(5, this.wordCount.getNumberOfWords(this.text));
    }

    @Test
    public void checkTextWithNonWords(){
        this.text = "Old McDonald had a farm, E—I—E—I—O";

        Assert.assertEquals(4, this.wordCount.getNumberOfWords(this.text));
    }

    @Test
    public void checkWhenTextHasTwoSpaces(){
        this.text = "Two  spaces";

        Assert.assertEquals(2, this.wordCount.getNumberOfWords(this.text));
    }
}
