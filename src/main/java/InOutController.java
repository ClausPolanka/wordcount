import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;

import data.CountResult;

public class InOutController {

	private final WordCountFileReader wordCountFileReader;
	private final ConsoleInterface consoleInterface;

	public InOutController(WordCountFileReader wordCountFileReader, ConsoleInterface consoleInterface) {
		this.wordCountFileReader = wordCountFileReader;
		this.consoleInterface = consoleInterface;
	}

	public String getInput(String fileName) throws IOException {
		if (fileName == null) {
			System.out.print("Enter text: ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		} else {
			return wordCountFileReader.readFullFile(fileName);
		}
	}

	public void printResultsToConsole(boolean index, CountResult result) {
		System.out.println("Number of words: " + result.getCount() + ", unique:" + result.getUnique()
				+ "; average word length: " + result.getAverage().setScale(2, RoundingMode.HALF_UP) + " characters");
		if (index) {
			System.out.println("Index:");
			result.getWords().forEach(w -> System.out.println(w));
		}
	}

}
