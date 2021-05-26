package wordcount;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.List;

import wordcount.data.CountResult;
import wordcount.data.StartParameters;
import wordcount.iosupport.ConsoleInterface;
import wordcount.iosupport.WordCountFileReaderInterface;

public class WordCounter {

	private final ConsoleInterface consoleInterface;
	private final WordCountFileReaderInterface wordCountFileReader;

	public WordCounter(ConsoleInterface consoleInterface, WordCountFileReaderInterface wordCountFileReader) {
		this.consoleInterface = consoleInterface;
		this.wordCountFileReader = wordCountFileReader;
	}

	public void countWordsAndStatistics(StartParameters params) throws IOException {

		String input = null;
		if (params.getFileName() == null) {
			input = consoleInterface.readFromConsole();
		} else {
			input = wordCountFileReader.readFullFile(params.getFileName());
		}

		List<String> stopWords = wordCountFileReader.readWordsFromFile("stopwords.txt");

		CountResult result = new WordCounterStatistics().getWordStatistics(input, stopWords);

		printNiceFormattedResultsToConsole(params.isIndex(), result);
	}

	public void printNiceFormattedResultsToConsole(boolean index, CountResult result) {
		consoleInterface.printToConsole("Number of words: " + result.getCount() + ", unique:" + result.getUnique()
				+ "; average word length: " + result.getAverage().setScale(2, RoundingMode.HALF_UP) + " characters");
		if (index) {
			consoleInterface.printToConsole("Index:");
			result.getWords().forEach(w -> consoleInterface.printToConsole(w));
		}
	}

}
