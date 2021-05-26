import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import data.CountResult;

public class WordCounter {

	public CountResult countWords(String input, List<String> stopwords) {

		if (input == null) {
			return new CountResult(0, 0, BigDecimal.ZERO);
		}

		String[] parts = input.split("[\s\r\n\\.]");

		List<String> words = Arrays.stream(parts).filter(s -> isWord(s)).filter(s -> notAStopWord(s, stopwords))
				.collect(Collectors.toList());
		Set<String> uniqueWords = new HashSet<>(words);

		BigDecimal average = new BigDecimal(words.stream().mapToDouble(String::length).average().orElse(0));

		return new CountResult(words.size(), uniqueWords.size(), average);
	}

	private boolean notAStopWord(String word, List<String> stopwords) {
		return stopwords == null || !stopwords.contains(word);
	}

	private boolean isWord(String input) {
		return input.matches("[a-zA-Z-]+");
	}

}
