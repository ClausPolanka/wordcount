package word.ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileReader implements IReader {

	String fileName;
	List<String> lineWords = Collections.<String>emptyList();

	public FileReader(String fileName) {
		this.fileName = fileName;
		getText();
	}

	@Override
	public String getText() {
		StringBuilder result = new StringBuilder("");
		ClassLoader classLoader = getClass().getClassLoader();
		lineWords = new    ArrayList<>();
		File file = new File(classLoader.getResource(this.fileName).getFile());
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				lineWords.add(line);
				result.append(line).append("\n");
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result.toString();
	}

	public List<String> getLineWords() {
		return lineWords;
	}

	 

}
