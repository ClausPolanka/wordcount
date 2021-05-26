import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import data.CountResult;

public class WordCounter {

	public CountResult countWords(String input, List<String> stopwords) {

		if (input == null) {
			return new CountResult(0, 0);
		}

		String[] parts = input.split("[\s\r\n\\.-]");

		Set<String> uniqueWords = new HashSet<>();
		Long count = Arrays.stream(parts).filter(s -> isWord(s)).filter(s -> notAStopWord(s, stopwords))
				.peek(s -> uniqueWords.add(s)).count();

		return new CountResult(count, uniqueWords.size());
	}

	private boolean notAStopWord(String word, List<String> stopwords) {
		return stopwords == null || !stopwords.contains(word);
	}

	private boolean isWord(String input) {
		return input.matches("[a-zA-Z]+");
	}

}
