package hiring.wordcount.service;

public interface InputReaderService extends BaseService {

    String read(String path) throws Exception;

}
