package word.op;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class AverageOperations {
 	
	 public static BigDecimal getAverageWordLength(List<String> wordList) {
	        BigDecimal count = BigDecimal.valueOf(wordList.size());
	        BigDecimal totalLength = BigDecimal.valueOf(wordList.stream().mapToInt(String::length).sum());
	         return totalLength.divide(count, 2, RoundingMode.HALF_UP);
	    }

}
