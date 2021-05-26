import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import data.CountResult;

class WordCounterTest {

	@Test
	void testWordSeparations() {
		WordCounter sut = new WordCounter();
		assertTrue(compareCountAndUniqueOnly(1, 1, sut.countWords("one", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(3, 3, sut.countWords("one two three", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(0, 0, sut.countWords("", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(0, 0, sut.countWords("one,two,three", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(3, 3, sut.countWords("one      two    three", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(1, 1, sut.countWords("on1e tw2o three", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(0, 0, sut.countWords(null, Collections.emptyList())));
	}

	@Test
	void testWordsWithNewLine() {
		WordCounter sut = new WordCounter();
		assertTrue(compareCountAndUniqueOnly(3, 3, sut.countWords("one two\nthree", Collections.emptyList())));
		assertTrue(
				compareCountAndUniqueOnly(3, 3, sut.countWords("one \r\n\r\n\ntwo\nthree", Collections.emptyList())));
	}

	@Test
	void testWordsWithDot() {
		WordCounter sut = new WordCounter();
		assertTrue(compareCountAndUniqueOnly(1, 1, sut.countWords("one.", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(3, 2, sut.countWords("one.one.two", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(3, 2, sut.countWords("one. one two", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(3, 2, sut.countWords("...one. one two...", Collections.emptyList())));

	}

	@Test
	void testWordsWithMinus() {
		WordCounter sut = new WordCounter();
		assertTrue(compareCountAndUniqueOnly(1, 1, sut.countWords("Humpty-Dumpty", Arrays.asList("on", "a"))));
		assertTrue(compareCountAndUniqueOnly(7, 6, sut
				.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", Arrays.asList("on", "a"))));
	}

	@Test
	void testWordUniqueness() {
		WordCounter sut = new WordCounter();
		assertTrue(compareCountAndUniqueOnly(4, 1, sut.countWords("one one one one", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(4, 2, sut.countWords("one one two two ", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(3, 2, sut.countWords("one two one", Collections.emptyList())));
	}

	@Test
	void testStopWords() {
		WordCounter sut = new WordCounter();
		List<String> stopWords = Arrays.asList("one", "two", "three");

		assertTrue(compareCountAndUniqueOnly(0, 0, sut.countWords(null, null)));
		assertTrue(compareCountAndUniqueOnly(1, 1, sut.countWords("one", null)));
		assertTrue(compareCountAndUniqueOnly(0, 0, sut.countWords("one two three", stopWords)));
		assertTrue(compareCountAndUniqueOnly(1, 1, sut.countWords("one two three four", stopWords)));
		assertTrue(compareCountAndUniqueOnly(3, 3, sut.countWords("One Two Three", stopWords)));
		assertTrue(compareCountAndUniqueOnly(1, 1, sut.countWords("four", stopWords)));
		assertTrue(compareCountAndUniqueOnly(1, 1, sut.countWords("oneoneone", stopWords)));
		assertTrue(compareCountAndUniqueOnly(0, 0, sut.countWords("one one one", stopWords)));
	}

	@Test
	void testAverage1() {
		WordCounter sut = new WordCounter();
		CountResult result = sut.countWords("one one one one", Collections.emptyList());
		assertTrue(compareCountAndUniqueOnly(4, 1, result));
		assertEquals(new BigDecimal("3.00"), result.getAverage().setScale(2, RoundingMode.HALF_UP));
	}

	@Test
	void testAverage2() {
		WordCounter sut = new WordCounter();
		CountResult result = sut.countWords("one four four one", Collections.emptyList());
		assertTrue(compareCountAndUniqueOnly(4, 2, result));
		assertEquals(new BigDecimal("3.50"), result.getAverage().setScale(2, RoundingMode.HALF_UP));
	}

	@Test
	void testAverage3() {
		WordCounter sut = new WordCounter();
		CountResult result = sut.countWords("one four four", Collections.emptyList());
		assertTrue(compareCountAndUniqueOnly(3, 2, result));
		assertEquals(new BigDecimal("3.67"), result.getAverage().setScale(2, RoundingMode.HALF_UP));
	}

	@Test
	void testAverageZero() {
		WordCounter sut = new WordCounter();
		CountResult result = sut.countWords("", Collections.emptyList());
		assertTrue(compareCountAndUniqueOnly(0, 0, result));
		assertEquals(new BigDecimal("0.00"), result.getAverage().setScale(2, RoundingMode.HALF_UP));
	}

	private boolean compareCountAndUniqueOnly(long expectedCount, long expectedUnique, CountResult actual) {
		return expectedCount == actual.getCount() && expectedUnique == actual.getUnique();
	}

}
