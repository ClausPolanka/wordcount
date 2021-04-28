package hiring.wordcount.service;

import hiring.wordcount.exception.ValidatorNotFoundException;

import java.util.List;

public interface ParserService extends BaseService {

    ValidatorService getValidatorService();

    List<String> getWordsAsList(String input) throws ValidatorNotFoundException;

    void setValidator(ValidatorService validatorService);

}
