package wordcount.iosupport;
import java.io.IOException;
import java.util.List;

public interface WordCountFileReaderInterface {
	List<String> readWordsFromFile(String path) throws IOException;

	public String readFullFile(String filename) throws IOException;

}
