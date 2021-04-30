package wordcount.writer;

import java.io.IOException;

/**
 * used to handle output
 */
public interface OutputWriter {

    /**
     * writes output
     * @param output string
     * @throws IOException
     */
    void writeResult(String output) throws IOException;

}
