package wordcount;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import wordcount.WordCounterStatistics;
import wordcount.data.CountResult;

class WordCounterStatisticsTest {

	@Test
	void testWordSeparations() {
		WordCounterStatistics sut = new WordCounterStatistics();
		assertTrue(compareCountAndUniqueOnly(1, 1, sut.getWordStatistics("one", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(3, 3, sut.getWordStatistics("one two three", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(0, 0, sut.getWordStatistics("", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(0, 0, sut.getWordStatistics("one,two,three", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(3, 3,
				sut.getWordStatistics("one      two    three", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(1, 1, sut.getWordStatistics("on1e tw2o three", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(0, 0, sut.getWordStatistics(null, Collections.emptyList())));
	}

	@Test
	void testWordsWithNewLine() {
		WordCounterStatistics sut = new WordCounterStatistics();
		assertTrue(compareCountAndUniqueOnly(3, 3, sut.getWordStatistics("one two\nthree", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(3, 3,
				sut.getWordStatistics("one \r\n\r\n\ntwo\nthree", Collections.emptyList())));
	}

	@Test
	void testWordsWithDot() {
		WordCounterStatistics sut = new WordCounterStatistics();
		assertTrue(compareCountAndUniqueOnly(1, 1, sut.getWordStatistics("one.", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(3, 2, sut.getWordStatistics("one.one.two", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(3, 2, sut.getWordStatistics("one. one two", Collections.emptyList())));
		assertTrue(
				compareCountAndUniqueOnly(3, 2, sut.getWordStatistics("...one. one two...", Collections.emptyList())));

	}

	@Test
	void testWordsWithMinus() {
		WordCounterStatistics sut = new WordCounterStatistics();
		assertTrue(compareCountAndUniqueOnly(1, 1, sut.getWordStatistics("Humpty-Dumpty", Arrays.asList("on", "a"))));
		assertTrue(compareCountAndUniqueOnly(7, 6, sut.getWordStatistics(
				"Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", Arrays.asList("on", "a"))));
	}

	@Test
	void testWordUniqueness() {
		WordCounterStatistics sut = new WordCounterStatistics();
		assertTrue(compareCountAndUniqueOnly(4, 1, sut.getWordStatistics("one one one one", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(4, 2, sut.getWordStatistics("one one two two ", Collections.emptyList())));
		assertTrue(compareCountAndUniqueOnly(3, 2, sut.getWordStatistics("one two one", Collections.emptyList())));
	}

	@Test
	void testStopWords() {
		WordCounterStatistics sut = new WordCounterStatistics();
		List<String> stopWords = Arrays.asList("one", "two", "three");

		assertTrue(compareCountAndUniqueOnly(0, 0, sut.getWordStatistics(null, null)));
		assertTrue(compareCountAndUniqueOnly(1, 1, sut.getWordStatistics("one", null)));
		assertTrue(compareCountAndUniqueOnly(0, 0, sut.getWordStatistics("one two three", stopWords)));
		assertTrue(compareCountAndUniqueOnly(1, 1, sut.getWordStatistics("one two three four", stopWords)));
		assertTrue(compareCountAndUniqueOnly(3, 3, sut.getWordStatistics("One Two Three", stopWords)));
		assertTrue(compareCountAndUniqueOnly(1, 1, sut.getWordStatistics("four", stopWords)));
		assertTrue(compareCountAndUniqueOnly(1, 1, sut.getWordStatistics("oneoneone", stopWords)));
		assertTrue(compareCountAndUniqueOnly(0, 0, sut.getWordStatistics("one one one", stopWords)));
	}

	@Test
	void testAverage1() {
		WordCounterStatistics sut = new WordCounterStatistics();
		CountResult result = sut.getWordStatistics("one one one one", Collections.emptyList());
		assertTrue(compareCountAndUniqueOnly(4, 1, result));
		assertEquals(new BigDecimal("3.00"), result.getAverage().setScale(2, RoundingMode.HALF_UP));
	}

	@Test
	void testAverage2() {
		WordCounterStatistics sut = new WordCounterStatistics();
		CountResult result = sut.getWordStatistics("one four four one", Collections.emptyList());
		assertTrue(compareCountAndUniqueOnly(4, 2, result));
		assertEquals(new BigDecimal("3.50"), result.getAverage().setScale(2, RoundingMode.HALF_UP));
	}

	@Test
	void testAverage3() {
		WordCounterStatistics sut = new WordCounterStatistics();
		CountResult result = sut.getWordStatistics("one four four", Collections.emptyList());
		assertTrue(compareCountAndUniqueOnly(3, 2, result));
		assertEquals(new BigDecimal("3.67"), result.getAverage().setScale(2, RoundingMode.HALF_UP));
	}

	@Test
	void testAverageZero() {
		WordCounterStatistics sut = new WordCounterStatistics();
		CountResult result = sut.getWordStatistics("", Collections.emptyList());
		assertTrue(compareCountAndUniqueOnly(0, 0, result));
		assertEquals(new BigDecimal("0.00"), result.getAverage().setScale(2, RoundingMode.HALF_UP));
	}

	@Test
	void testIndex() {
		WordCounterStatistics sut = new WordCounterStatistics();
		CountResult result = sut.getWordStatistics("one four four", Collections.emptyList());
		assertTrue(compareCountAndUniqueOnly(3, 2, result));
		assertEquals(new BigDecimal("3.67"), result.getAverage().setScale(2, RoundingMode.HALF_UP));
		assertEquals(2, result.getWords().size());
		assertEquals(Arrays.asList("four", "one"), result.getWords());

	}

	private boolean compareCountAndUniqueOnly(long expectedCount, long expectedUnique, CountResult actual) {
		return expectedCount == actual.getCount() && expectedUnique == actual.getUnique();
	}

}
