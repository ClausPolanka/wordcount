package wordcount.iosupport;
import java.io.IOException;
import java.util.List;

import wordcount.iosupport.WordCountFileReaderInterface;

public class SpyFileReader implements WordCountFileReaderInterface {

	private final String fileContent;
	private final List<String> words;

	public SpyFileReader(String fileContent, List<String> words) {
		this.fileContent = fileContent;
		this.words = words;
	}

	@Override
	public List<String> readWordsFromFile(String path) throws IOException {
		return words;
	}

	@Override
	public String readFullFile(String filename) throws IOException {
		return fileContent;
	}

	public String getFileContent() {
		return fileContent;
	}

	public List<String> getWords() {
		return words;
	}

}
