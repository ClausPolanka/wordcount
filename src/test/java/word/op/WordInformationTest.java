package word.op;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

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
	public void WHEN_valid_input_THEN_return_Size() {

		Writer writer = new Writer();
		FileReader fileReaderstops = new FileReader("stopwords.txt");
		FileReader fileReaderWords = new FileReader("mytext.txt");
		stopWords = new StopWords(fileReaderstops);
		winfo = new WordInformation(stopWords);
		assertEquals(4, winfo.getUniqueValidWordsWitoutStopWords(fileReaderWords.getText()).size());
		assertEquals(4, winfo.getValidWordsWitoutStopWords(fileReaderWords.getText()).size());

		BigDecimal avg = AverageOperations
				.getAverageWordLength(winfo.getValidWordsWitoutStopWords(fileReaderWords.getText()));
		 
		writer.message = String.format("Number of words: %d, unique: %d; average word length: %.2f characters",
				 winfo.getValidWordsWitoutStopWords(fileReaderWords.getText()).size() ,
				 winfo.getUniqueValidWordsWitoutStopWords(fileReaderWords.getText()).size() , 
				  avg );

		assertEquals("Number of words: 4, unique: 4; average word length: 4,25 characters", writer.message);
	}
	
	
	@Test
	public void WHEN_valid_inputwith_index_THEN_return_Size() {
		
		Reader reader = new Reader("-index Mary had a little lamb");
		Writer writer = new Writer();
		FileReader fileReader = new FileReader("stopwords.txt");
		stopWords = new StopWords(fileReader);
		winfo = new WordInformation(stopWords);
		
		assertEquals(4, winfo.getUniqueValidWordsWitoutStopWords(reader.getText()).size());
		assertEquals(4, winfo.getValidWordsWitoutStopWords(reader.getText()).size());

		BigDecimal avg = AverageOperations
				.getAverageWordLength(winfo.getValidWordsWitoutStopWords(reader.getText()));
		 
		writer.message = String.format("Number of words: %d, unique: %d; average word length: %.2f characters",
				 winfo.getValidWordsWitoutStopWords(reader.getText()).size() ,
				 winfo.getUniqueValidWordsWitoutStopWords(reader.getText()).size() , 
				  avg );

		assertEquals("Number of words: 4, unique: 4; average word length: 4,25 characters", writer.message);
	}
	

	static class Reader implements IReader {
		private String text;

		public Reader(String text) {
			this.text = text;
		}

		@Override
		public String getText() {

			return text;
		}

	}

	static class Writer implements IWriter {

		private String message;

		public void writeText(String message) {

			this.message = message;
		}

	}
}
