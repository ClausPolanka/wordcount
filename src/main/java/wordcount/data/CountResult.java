package wordcount.data;

import java.math.BigDecimal;
import java.util.List;

public class CountResult {

	private long count;
	private long unique;
	private BigDecimal average;
	private List<String> words;

	public CountResult(long count, long unique, BigDecimal average, List<String> words) {
		super();
		this.count = count;
		this.unique = unique;
		this.average = average;
		this.words = words;
	}

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public long getUnique() {
		return unique;
	}

	public void setUnique(long unique) {
		this.unique = unique;
	}

	public BigDecimal getAverage() {
		return average;
	}

	public void setAverage(BigDecimal average) {
		this.average = average;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((average == null) ? 0 : average.hashCode());
		result = prime * result + (int) (count ^ (count >>> 32));
		result = prime * result + (int) (unique ^ (unique >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountResult other = (CountResult) obj;
		if (average == null) {
			if (other.average != null)
				return false;
		} else if (!average.equals(other.average))
			return false;
		if (count != other.count)
			return false;
		if (unique != other.unique)
			return false;
		return true;
	}

}
