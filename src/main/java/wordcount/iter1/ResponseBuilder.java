package wordcount.iter1;

public class ResponseBuilder {

    public String createOutputMessage(long count) {
        return String.format("Number of words: %d", count);
    }
}
