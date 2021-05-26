import java.io.IOException;
import java.util.List;

public class MainClass {

	public static void main(String... args) throws IOException {

		String filename = null;
		if (args.length == 1) {
			filename = args[0];
		}

		WordCountFileReader wordCountFileReader = new WordCountFileReader();

		String input = new InputController(wordCountFileReader).getInput(filename);

		List<String> stopWords = wordCountFileReader.readWordsFromFile("stopwords.txt");

		long result = new WordCounter().countWords(input, stopWords);

		System.out.print("Number of words: " + result);
	}

}
