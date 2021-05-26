import java.io.IOException;
import java.util.List;

import data.CountResult;
import data.StartParameters;

public class MainClass {

	public static void main(String... args) throws IOException {

		StartParameters params = getFromParams(args);

		WordCountFileReader wordCountFileReader = new WordCountFileReader();
		InOutController inOutController = new InOutController(wordCountFileReader, new ConsoleAdapter());

		String input = inOutController.getInput(params.getFileName());
		List<String> stopWords = wordCountFileReader.readWordsFromFile("stopwords.txt");

		CountResult result = new WordCounter().getWordStatistics(input, stopWords);

		inOutController.printResultsToConsole(params.isIndex(), result);
	}

	public static StartParameters getFromParams(String... params) {
		if (params == null || params.length == 0) {
			return new StartParameters(false, null);
		}

		if (params.length == 1) {
			if (params[0].equals("-index")) {
				return new StartParameters(true, null);
			} else {
				return new StartParameters(false, params[0]);
			}
		}

		if (params[1].equals("-index")) {
			return new StartParameters(true, params[0]);
		} else {
			return new StartParameters(false, params[0]);
		}

	}

}
