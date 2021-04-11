package word.ui;

public class ReaderFactory {
	
	public static boolean  indexParam = false;
	  
	public static IReader getReader(String[] a) {
		if (a.length == 0 || a[0].startsWith("-index")) {
			if ( a[0].startsWith("-index")) {
					indexParam = Boolean.TRUE;
			}
			return new ConsoleReader();
		} else {
			return null;
		}

	}
}
