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
		IWriter print = new ConsoleWriter();
		print.writeText("Enter the text:");
		IReader input = ReaderFactory.getReader(args);
		FileReader fileReader = new FileReader("stopwords.txt");
		StopWords stopWords = new StopWords(fileReader);
		WordInformation info = new WordInformation(stopWords);
		print.writeText(String.format("Number of words: %d, unique: %d"
				,Integer.toString(info.getValidWords(input.getText()).size()),
				Integer.toString(info.getUniqueValidWordsWitoutStopWords(input.getText()).size())));

	}

}
