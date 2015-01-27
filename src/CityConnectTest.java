import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;


public class CityConnectTest {

	@Test
	public void invalidCommandTest() {
		String input="abcd";
		initialise(input);
		assertEquals("invalid command format :abcd",CityConnect.executeCommand(input));
		
	}
	
	//method to simulate command line input by changing System.in to take in strings
	private void initialise(String input) {
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	}
}
