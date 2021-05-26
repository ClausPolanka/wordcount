import java.util.Arrays;
import java.util.List;

public class WordCounter {

	public long countWords(String input, List<String> stopwords) {

		if (input == null) {
			return 0;
		}

		String[] parts = input.split("\s");

		return Arrays.stream(parts).filter(s -> isWord(s)).filter(s -> notAStopWord(s, stopwords)).count();
	}

	private boolean notAStopWord(String word, List<String> stopwords) {
		return stopwords == null || !stopwords.contains(word);
	}

	private boolean isWord(String input) {
		return input.matches("[a-zA-Z]+");
	}

}
