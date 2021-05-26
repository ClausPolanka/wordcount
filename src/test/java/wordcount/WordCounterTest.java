package wordcount;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import wordcount.data.StartParameters;
import wordcount.iosupport.SpyConsoleAdapter;
import wordcount.iosupport.SpyFileReader;

class WordCounterTest {

	@Test
	void testConsoleInput() throws IOException {

		SpyConsoleAdapter consoleAdapter = new SpyConsoleAdapter("Mary had a little lamb");
		SpyFileReader fileReader = new SpyFileReader("", Arrays.asList("of", "a"));
		StartParameters params = new StartParameters(false, null);

		new WordCounter(consoleAdapter, fileReader).countWordsAndStatistics(params);

		assertEquals(String.format("%s%n", "Number of words: 4, unique:4; average word length: 4.25 characters"),
				consoleAdapter.getOutput());
	}

	@Test
	void testFileInput() throws IOException {

		SpyConsoleAdapter consoleAdapter = new SpyConsoleAdapter("");
		SpyFileReader fileReader = new SpyFileReader("Mary had a little lamb", Arrays.asList("of", "a"));
		StartParameters params = new StartParameters(false, "mytext.txt");

		new WordCounter(consoleAdapter, fileReader).countWordsAndStatistics(params);

		assertEquals(String.format("%s%n", "Number of words: 4, unique:4; average word length: 4.25 characters"),
				consoleAdapter.getOutput());
	}

	@Test
	void testFileInputWithIndex() throws IOException {

		SpyConsoleAdapter consoleAdapter = new SpyConsoleAdapter("");
		SpyFileReader fileReader = new SpyFileReader("Mary had a little lamb", Arrays.asList("of", "a"));
		StartParameters params = new StartParameters(true, "mytext.txt");

		new WordCounter(consoleAdapter, fileReader).countWordsAndStatistics(params);

		assertEquals(
				"Number of words: 4, unique:4; average word length: 4.25 characters" + System.lineSeparator() 
				+ "Index:"+ System.lineSeparator() 
				+ "had" + System.lineSeparator() 
				+ "lamb" + System.lineSeparator()
				+ "little" + System.lineSeparator()
				+ "Mary" + System.lineSeparator(),
				consoleAdapter.getOutput());
	}

}
