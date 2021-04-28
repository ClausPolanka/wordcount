package hiring.wordcount.service;

import java.util.List;

public interface ParserService extends BaseService {

    List<String> getWordsAsList(String input);

}
