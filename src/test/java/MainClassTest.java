import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import data.StartParameters;

public class MainClassTest {

	@Test
	public void testMain1() {

	}

	@Test
	public void testParameterResolution() {
		StartParameters params = MainClass.getFromParams(new String[] { "-index" });
		assertTrue(params.isIndex());
	}

}
