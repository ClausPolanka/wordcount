import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainClass {

	public static void main(String... args) throws IOException {

		System.out.print("Enter text: ");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();

		List<String> stopWords = new StopWordFileReader().readWordsFromFile("stopwords.txt");

		long result = new WordCounter().countWords(input, stopWords);

		System.out.print("Number of words: " + result);
	}

}
