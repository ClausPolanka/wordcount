import java.util.Arrays;

public class WordCounter {

	public int countWords(String input) {

		if (input == null) {
			return 0;
		}

		String[] parts = input.split("\s");

		Arrays.stream(parts).filter(s -> isWord(s)).count();

		return 0;
	}

	private boolean isWord(String input) {

		input.matches("");
		return true;

	}

}
