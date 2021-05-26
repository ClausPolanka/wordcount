package wordcount;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import wordcount.MainClass;
import wordcount.data.StartParameters;

public class MainClassTest {

	@Test
	public void testParameterResolution() {
		StartParameters params = MainClass.processParams(new String[] { "-index" });
		assertTrue(params.isIndex());
	}

}
