package hiring.wordcount.service;

import hiring.wordcount.exception.ValidatorException;

import java.util.List;

public interface ParserService extends BaseService {

    List<String> getWordsAsList(String input) throws ValidatorException;

}
