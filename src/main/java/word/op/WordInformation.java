package word.op;

import java.util.Arrays;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class WordInformation implements IWord {
	
	private final StopWords stopWords;
	
	  public WordInformation(StopWords stopWords) {
		 this.stopWords = stopWords;
	}

	@Override
	public int getWordCount(String text) {
		if ((text == "") || (text.equals(null))) {
			return 0;
		} else {
			return getValidWords(text).size();
		}
	}
	
	@Override
	public Set<String> getWords(String text) {
		return Arrays.stream(text.split(ConstantRegex.SPACE_AND_WHITESPACE)).collect(Collectors.toSet());
	}
	
	public Set<String> getValidWords(String text) {
        return getWords(text)
				.stream()
				.filter(x -> x.matches(ConstantRegex.VALID_WORD))
				.collect(Collectors.toSet());
	}
	
	public Set<String> getValidWordsWitoutStopWords(String text){
		return getValidWords(text)
		.stream()
		.filter(not( this.stopWords.getStopWords()::contains))
		.collect(Collectors.toSet());
	 }
	
	
	private static <T> Predicate<T> not(Predicate<T> predicate) {
        return predicate.negate();
    }

}
