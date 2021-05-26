import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class InputControllerTest {

	@Test
	void testFileNameGiven() throws IOException {
		WordCountFileReader wordCountFileReader = new WordCountFileReader();
		InputController sut = new InputController(wordCountFileReader);

		String result = sut.getInput("mytexttest.txt");
		assertEquals("Mary had\r\n" + "a little\r\n" + "lamb 2", result);
	}

	@Test
	void testNoFileNameGiven() throws IOException {
		WordCountFileReader wordCountFileReader = new WordCountFileReader();
		InputController sut = new InputController(wordCountFileReader);

		// set stdin
		System.setIn(new ByteArrayInputStream("Mary had a little lamb".getBytes()));

		String result = sut.getInput(null);
		assertEquals("Mary had a little lamb", result);
	}

}
