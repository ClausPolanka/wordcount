import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputController {

	private final WordCountFileReader wordCountFileReader;

	public InputController(WordCountFileReader wordCountFileReader) {
		this.wordCountFileReader = wordCountFileReader;
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

}
