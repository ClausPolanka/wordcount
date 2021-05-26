package wordcount;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import wordcount.data.CountResult;

public class WordCounterStatistics {

	public CountResult getWordStatistics(String input, List<String> stopwords) {

		if (input == null) {
			return new CountResult(0, 0, BigDecimal.ZERO, Collections.emptyList());
		}

		String[] parts = input.split("[\\s\r\n.]");

		List<String> words = Arrays.stream(parts).filter(s -> isWord(s)).filter(s -> notAStopWord(s, stopwords))
				.collect(Collectors.toList());
		Set<String> uniqueWords = new HashSet<>(words);

		BigDecimal average = new BigDecimal(words.stream().mapToDouble(String::length).average().orElse(0));

		List<String> index = new ArrayList<>(uniqueWords);
		Collections.sort(index, String.CASE_INSENSITIVE_ORDER);
		return new CountResult(words.size(), uniqueWords.size(), average, index);
	}

	private boolean notAStopWord(String word, List<String> stopwords) {
		return stopwords == null || !stopwords.contains(word);
	}

	private boolean isWord(String input) {
		return input.matches("[a-zA-Z-]+");
	}

}
