package word;

import word.op.AverageOperations;
import word.op.StopWords;
import word.op.WordInformation;
import word.ui.ConsoleWriter;
import word.ui.FileReader;
import word.ui.IReader;
import word.ui.IWriter;
import word.ui.ReaderFactory;

public class WordCountMainApp {

	public static void main(String[] args) {
		new WordCountMainApp().run(args);
	}

	public void run(String[] args) {
		IWriter print = new ConsoleWriter();

		print.writeText("Enter the text:");
		IReader input = ReaderFactory.getReader(args);

		FileReader fileReaderstops = new FileReader("stopwords.txt");

		StopWords stopWords = new StopWords(fileReaderstops);
		WordInformation info = new WordInformation(stopWords);
		print.writeText(String.format("Number of words: %d, unique: %d; average word length:%.2f characters \n",
				Integer.toString(info.getValidWords(input.getText()).size()),
				Integer.toString(info.getUniqueValidWordsWitoutStopWords(input.getText()).size()),
				AverageOperations.getAverageWordLength(info.getValidWordsWitoutStopWords(input.getText()))));

		if (ReaderFactory.indexParam) {
			print.writeText("Index:\n");
			info.getUniqueValidWordsWitoutStopWords(input.getText()).stream().peek(x -> print.writeText(x + "\n"));

		}
	}

}
