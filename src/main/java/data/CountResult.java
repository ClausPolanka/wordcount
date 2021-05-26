package data;

public class CountResult {

	private long count;
	private long unique;

	public CountResult(long count, long unique) {
		super();
		this.count = count;
		this.unique = unique;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (count != other.count)
			return false;
		if (unique != other.unique)
			return false;
		return true;
	}

}
