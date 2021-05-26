import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

class WordCountFileReaderTest {

	@Test
	void testReadWordsFromFile() throws IOException {

		WordCountFileReader sut = new WordCountFileReader();

		List<String> result = sut.readWordsFromFile("stopwordstest.txt");

		assertEquals(5, result.size());
		assertTrue(result.contains("not"));
		assertTrue(result.contains("the"));
		assertTrue(result.contains("a"));
		assertTrue(result.contains("on"));
		assertTrue(result.contains("off"));
	}

	@Test
	void testReadFullFile() throws IOException {
		WordCountFileReader sut = new WordCountFileReader();

		String result = sut.readFullFile("mytexttest.txt");
		assertEquals("Mary had\r\n" + "a little\r\n" + "lamb 2", result);
	}

}
