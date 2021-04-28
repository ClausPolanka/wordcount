package hiring.wordcount.service;

import hiring.wordcount.exception.ValidatorNotFoundException;

import java.util.List;

public interface ParserService extends BaseService {

    void setValidator(ValidatorService validatorService);

    ValidatorService getValidatorService();

    List<String> getWordsAsList(String input) throws ValidatorNotFoundException;

}
