package wordcount;
import java.io.IOException;

import wordcount.data.StartParameters;
import wordcount.iosupport.ConsoleAdapter;
import wordcount.iosupport.ConsoleInterface;
import wordcount.iosupport.WordCountFileReader;
import wordcount.iosupport.WordCountFileReaderInterface;

public class MainClass {

	public static void main(String... args) throws IOException {

		StartParameters params = processParams(args);

		ConsoleInterface consoleInterface = new ConsoleAdapter();
		WordCountFileReaderInterface wordCountFileReader = new WordCountFileReader();

		new WordCounter(consoleInterface, wordCountFileReader).countWordsAndStatistics(params);

	}

	public static StartParameters processParams(String... params) {
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
