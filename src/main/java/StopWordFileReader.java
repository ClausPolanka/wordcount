import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StopWordFileReader {

	public List<String> readWordsFromFile(String path) throws IOException {

		File file = new File(getClass().getClassLoader().getResource(path).getFile());
		FileReader fileReader = new FileReader(file);
		try (BufferedReader br = new BufferedReader(fileReader)) {

			List<String> results = new ArrayList<>();

			String line;
			while ((line = br.readLine()) != null) {
				results.add(line);
			}

			return results;
		}
	}

	public static String readFullFile(String filename) throws IOException {
		String content = null;

		content = new String(Files.readAllBytes(Paths.get(filename)));

		return content;
	}

}
