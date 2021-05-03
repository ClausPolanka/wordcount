package wordcount.reader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * used to handle input
 */
public interface InputReader {

    /**
     * reads a line
     * @return
     */
    List<String> readLines() throws IOException;

}
