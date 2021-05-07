package wordcount;

public class ResponseBuilder {

    public String createOutputMessage(WordCounterOutput output) {
        return String.format(
                "Number of words: %d, unique: %d; average word length: %.2f characters",
                output.getWordCount(),
                output.getUniqueCount(),
                output.getWordAverage()
        );
    }
}
