package wordcount;

public class ResponseBuilder {

    public String createOutputMessage(long count) {
        return String.format("Number of words: %d", count);
    }
}
