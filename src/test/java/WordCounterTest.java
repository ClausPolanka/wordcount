import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import data.CountResult;

class WordCounterTest {

	@Test
	void testWordSeparations() {
		WordCounter sut = new WordCounter();
		assertEquals(new CountResult(1, 1), sut.countWords("one", Collections.emptyList()));
		assertEquals(new CountResult(3, 3), sut.countWords("one two three", Collections.emptyList()));
		assertEquals(new CountResult(0, 0), sut.countWords("", Collections.emptyList()));
		assertEquals(new CountResult(0, 0), sut.countWords("one,two,three", Collections.emptyList()));
		assertEquals(new CountResult(3, 3), sut.countWords("one      two    three", Collections.emptyList()));
		assertEquals(new CountResult(1, 1), sut.countWords("on1e tw2o three", Collections.emptyList()));
		assertEquals(new CountResult(0, 0), sut.countWords(null, Collections.emptyList()));
	}

	@Test
	void testWordsWithNewLine() {
		WordCounter sut = new WordCounter();
		assertEquals(new CountResult(3, 3), sut.countWords("one two\nthree", Collections.emptyList()));
		assertEquals(new CountResult(3, 3), sut.countWords("one \r\n\r\n\ntwo\nthree", Collections.emptyList()));
	}

	@Test
	void testWordsWithDot() {
		WordCounter sut = new WordCounter();
		assertEquals(new CountResult(1, 1), sut.countWords("one.", Collections.emptyList()));
		assertEquals(new CountResult(3, 2), sut.countWords("one.one.two", Collections.emptyList()));
		assertEquals(new CountResult(3, 2), sut.countWords("one. one two", Collections.emptyList()));
		assertEquals(new CountResult(3, 2), sut.countWords("...one. one two...", Collections.emptyList()));

	}

	@Test
	void testWordsWithMinus() {
		WordCounter sut = new WordCounter();
		assertEquals(new CountResult(1, 1), sut.countWords("Humpty-Dumpty", Arrays.asList("on", "a")));
		assertEquals(new CountResult(7, 6), sut
				.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", Arrays.asList("on", "a")));
	}

	@Test
	void testWordUniqueness() {
		WordCounter sut = new WordCounter();
		assertEquals(new CountResult(4, 1), sut.countWords("one one one one", Collections.emptyList()));
		assertEquals(new CountResult(4, 2), sut.countWords("one one two two ", Collections.emptyList()));
		assertEquals(new CountResult(3, 2), sut.countWords("one two one", Collections.emptyList()));
	}

	@Test
	void testStopWords() {
		WordCounter sut = new WordCounter();
		List<String> stopWords = Arrays.asList("one", "two", "three");

		assertEquals(new CountResult(0, 0), sut.countWords(null, null));
		assertEquals(new CountResult(1, 1), sut.countWords("one", null));
		assertEquals(new CountResult(0, 0), sut.countWords("one two three", stopWords));
		assertEquals(new CountResult(1, 1), sut.countWords("one two three four", stopWords));
		assertEquals(new CountResult(3, 3), sut.countWords("One Two Three", stopWords));
		assertEquals(new CountResult(1, 1), sut.countWords("four", stopWords));
		assertEquals(new CountResult(1, 1), sut.countWords("oneoneone", stopWords));
		assertEquals(new CountResult(0, 0), sut.countWords("one one one", stopWords));
	}

}
