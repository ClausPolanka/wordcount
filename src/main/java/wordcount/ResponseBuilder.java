package wordcount;

public class ResponseBuilder {

    public String createOutputMessage(WordCounterOutput output) {
        return String.format(
                "Number of words: %d, unique: %d",
                output.getWordCount(),
                output.getUniqueCount()
        );
    }
}
