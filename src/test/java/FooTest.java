import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FooTest {

    @Test
    public void givenOneLetterWord_ShouldReturnOne() {
        //given
        String input = "a";

        // when
        int wordCount = new Foo().countWords(input);

        // then
        Assertions.assertEquals(1, wordCount);
    }

    @Test
    public void givenATwoLetterWord_ShouldReturnOne() {
        //given
        String input = "an";

        // when
        int wordCount = new Foo().countWords(input);

        // then
        Assertions.assertEquals(1, wordCount);
    }

    @Test
    public void givenATwoWord_ShouldReturnTwo() {
        //given
        String input = "a book";

        // when
        int wordCount = new Foo().countWords(input);

        // then
        Assertions.assertEquals(2, wordCount);
    }

    @Test
    public void givenATextOfFiveWords_ShouldReturnFive() {
        //given
        String input = "Mary had a little lamb";

        // when
        int wordCount = new Foo().countWords(input);

        // then
        Assertions.assertEquals(5, wordCount);
    }

    @Test
    public void givenATextOfSevenWordsAccordingToAssumptions_ShouldReturnSeven() {
        //given
        String input = "Mary had a little lamb, but I didn't.";

        // when
        int wordCount = new Foo().countWords(input);

        // then
        Assertions.assertEquals(7, wordCount);
    }

    @Test
    public void givenATextOf14WordsAccordingToAssumptions_ShouldReturn14() {
        //given
        String input = "Mary is a little girl, something else. The guys are playing outside, but I'm not.";

        // when
        int wordCount = new Foo().countWords(input);

        // then
        Assertions.assertEquals(14, wordCount);
    }

    @Test
    public void givenATextOf2WordsAndAStopWordsList_theCountShouldReturnOne() {
        // given
        String text = "an apple";
        String[] stopWords = new String[]{"an"};

        //when
        int wordCount = new Foo(stopWords).countWords(text);

        //when
        Assertions.assertEquals(1, wordCount);
    }
}
