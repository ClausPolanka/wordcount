package word;

import word.op.StopWords;
import word.op.WordInformation;
import word.ui.ConsoleWriter;
import word.ui.FileReader;
import word.ui.IReader;
import word.ui.IWriter;
import word.ui.ReaderFactory;

public class WordCountMainApp {

	public static void main(String[] args) {
		String filename = args[0];
		IWriter print = new ConsoleWriter(); 
		FileReader fileReaderWords = new FileReader(filename);
		FileReader fileReaderstops = new FileReader("stopwords.txt");
		
		StopWords stopWords = new StopWords(fileReaderstops);
		WordInformation info = new WordInformation(stopWords);
		print.writeText(String.format("Number of words: %d", 
				Integer.toString(info.getValidWordsWitoutStopWords(fileReaderWords.getText()).size())));
	}

}
