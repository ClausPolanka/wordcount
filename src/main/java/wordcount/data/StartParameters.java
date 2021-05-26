package wordcount.data;

public class StartParameters {
	private boolean index;
	private String fileName;

	public StartParameters(boolean index, String fileName) {
		super();
		this.index = index;
		this.fileName = fileName;
	}

	public boolean isIndex() {
		return index;
	}

	public void setIndex(boolean index) {
		this.index = index;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
