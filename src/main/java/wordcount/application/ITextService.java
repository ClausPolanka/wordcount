package wordcount.application;

import java.util.Optional;

public interface ITextService {

    public long count(Optional<String> fileName);

}
