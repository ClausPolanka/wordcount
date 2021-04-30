package wordcount.writer;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * OutputWriterImpl default implementation for handling output over streams
 */
public class OutputWriterImpl implements OutputWriter {

    private final OutputStream outputStream;

    /**
     * Default constructor constructs OutputWriter with an output from System.out
     */
    public OutputWriterImpl() {
        this(System.out);
    }

    /**
     * Custom constructor constructs OutputWriter with a given stream
     */
    public OutputWriterImpl(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    /**
     * Writes result to a stream using UTF_8 encoding
     * @param output
     * @throws IOException
     */
    @Override
    public void writeResult(String output) throws IOException {
        outputStream.write(output.getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
    }

}
