import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class WordCounterTest {

	@Test
	void testWordSeparations() {
		WordCounter sut = new WordCounter();
		assertEquals(1, sut.countWords("one", Collections.emptyList()));
		assertEquals(0, sut.countWords("one.", Collections.emptyList()));
		assertEquals(3, sut.countWords("one two three", Collections.emptyList()));
		assertEquals(0, sut.countWords("", Collections.emptyList()));
		assertEquals(0, sut.countWords("one,two,three", Collections.emptyList()));
		assertEquals(3, sut.countWords("one      two    three", Collections.emptyList()));
		assertEquals(1, sut.countWords("on1e tw2o three", Collections.emptyList()));
		assertEquals(0, sut.countWords(null, Collections.emptyList()));

		assertEquals(3, sut.countWords("one two\nthree", Collections.emptyList()));
		assertEquals(3, sut.countWords("one \r\n\r\n\ntwo\nthree", Collections.emptyList()));

	}

	@Test
	void testStopWords() {
		WordCounter sut = new WordCounter();
		List<String> stopWords = Arrays.asList("one", "two", "three");

		assertEquals(0, sut.countWords(null, null));
		assertEquals(1, sut.countWords("one", null));
		assertEquals(0, sut.countWords("one two three", stopWords));
		assertEquals(1, sut.countWords("one two three four", stopWords));
		assertEquals(3, sut.countWords("One Two Three", stopWords));
		assertEquals(1, sut.countWords("four", stopWords));
		assertEquals(1, sut.countWords("oneoneone", stopWords));
		assertEquals(0, sut.countWords("one one one", stopWords));
	}

}
