import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

class StopWordFileReaderTest {

	@Test
	void test() throws IOException {

		StopWordFileReader sut = new StopWordFileReader();

		List<String> result = sut.readWordsFromFile("stopwordstest.txt");

		assertEquals(5, result.size());
		assertTrue(result.contains("not"));
		assertTrue(result.contains("the"));
		assertTrue(result.contains("a"));
		assertTrue(result.contains("on"));
		assertTrue(result.contains("off"));

	}

}
