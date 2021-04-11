package word.op;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import word.op.WordInformationTest.Reader;
import word.op.WordInformationTest.Writer;
import word.ui.ConsoleWriter;
import word.ui.FileReader;
import word.ui.IReader;
import word.ui.IWriter;

public class WordInformationTest {

	WordInformation winfo;
	StopWords stopWords;

	@Test
	public void WHEN_empty_input_THEN_return_0() {
		Reader reader = new Reader("");
		Writer writer = new Writer();
		FileReader fileReader = new FileReader("stopwords.txt");
		stopWords = new StopWords(fileReader);
		winfo = new WordInformation(stopWords);
		assertEquals(0, winfo.getValidWordsWitoutStopWords(reader.getText()).size());
		writer.message = String.format("Number of words: %d",
				winfo.getValidWordsWitoutStopWords(reader.getText()).size());
		assertEquals("Number of words: 0", writer.message);
	}

	@Test
	public void WHEN_valid_input_THEN_return_Size() {
		Reader reader = new Reader("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
		Writer writer = new Writer();
		FileReader fileReader = new FileReader("stopwords.txt");
		stopWords = new StopWords(fileReader);
		winfo = new WordInformation(stopWords);
		
		assertEquals(6, winfo.getUniqueValidWordsWitoutStopWords(reader.getText()).size());
		assertEquals(7, winfo.getValidWordsWitoutStopWords(reader.getText()).size());

		writer.message = String.format("Number of words: %d, unique: %d",
				winfo.getValidWordsWitoutStopWords(reader.getText()).size(),
				winfo.getUniqueValidWordsWitoutStopWords(reader.getText()).size());
		assertEquals("Number of words: 7, unique: 6", writer.message);
	}

	@Test
	public void WHEN_invalid_input_THEN_return_0() {
		Reader reader = new Reader(" %%  ## a# #  #&&");
		Writer writer = new Writer();
		FileReader fileReader = new FileReader("stopwords.txt");
		stopWords = new StopWords(fileReader);
		winfo = new WordInformation(stopWords);
		assertEquals(0, winfo.getUniqueValidWordsWitoutStopWords(reader.getText()).size());
		assertEquals(0, winfo.getValidWords(reader.getText()).size());

		writer.message = String.format("Number of words: %d, unique: %d",
				winfo.getValidWordsWitoutStopWords(reader.getText()).size(),
				winfo.getUniqueValidWordsWitoutStopWords(reader.getText()).size());
		assertEquals("Number of words: 0, unique: 0", writer.message);
	}

	static class Reader implements IReader {
		String text;

		public Reader(String text) {
			this.text = text;
		}

		@Override
		public String getText() {

			return text;
		}

	}

	static class Writer implements IWriter {

		String message;

		@Override
		public void writeText(String message) {
			// TODO Auto-generated method stub
			this.message = message;
		}

	}
}
