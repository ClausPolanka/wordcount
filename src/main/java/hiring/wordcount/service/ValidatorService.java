package hiring.wordcount.service;

import hiring.wordcount.exception.ValidatorException;

public interface ValidatorService extends BaseService {

    boolean validate(String input) throws ValidatorException;

}
