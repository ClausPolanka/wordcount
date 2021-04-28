package hiring.wordcount.util;

import hiring.wordcount.service.BaseService;

import java.util.ServiceLoader;

public class WordCountServiceProvider {
    private static WordCountServiceProvider instance;

    private WordCountServiceProvider() {}

    public static WordCountServiceProvider getInstance() {
        if (instance == null)
            instance = new WordCountServiceProvider();
        return instance;
    }

    public static <T extends BaseService> T load(Class<T> serviceInterface, String filter) {
        T returnValue = null;

        ServiceLoader<? extends BaseService> serviceLoader = ServiceLoader.load(serviceInterface);

        for (BaseService service : serviceLoader) {
            if (service.getServiceName().equalsIgnoreCase(filter))
                returnValue = (T) service;
        }

        return returnValue;
    }
}
