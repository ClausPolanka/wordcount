import org.junit.jupiter.api.Test;
import src.main.java.api.Foo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FooTest {

    @Test
    public void testCountWords()
    {
        String sampleText = "This is a sample text! Text is not unique!";
        Foo foo = new Foo();
        assertEquals(9,foo.countWords(sampleText));
    }

    @Test
    public void testCountStopperWords()
    {
        String sampleText = "This is a sample text! Text is not unique!";
        Foo foo = new Foo("src/resources/sample.txt");
        assertEquals(5,foo.countWordsWithStopper(sampleText));
    }

    @Test
    public void testCountUniqueWords()
    {
        String sampleText = "This is a sample text! Text is not unique!";
        Foo foo = new Foo();
        assertEquals(7,foo.countUniqueWords(sampleText));
    }

    @Test
    public void testAvgWords()
    {
        String sampleText = "a bb ccc dddd";
        Foo foo = new Foo();
        assertEquals(2.5,foo.getWordAvgLength(sampleText));
    }
}
