package util;

import org.apache.commons.lang3.StringUtils;

public class ValidationUtil {

    public static boolean isValidInput(String str){

        return StringUtils.isNotBlank(str);

    }
}
