package hiring.wordcount.service;

import hiring.wordcount.exception.ValidatorException;

public interface ValidatorService extends BaseService {

    void setValidatorResource(String resource);

    boolean validate(String input) throws ValidatorException;

}
