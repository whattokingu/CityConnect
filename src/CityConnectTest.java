import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;


public class CityConnectTest {

	@Test
	public void testInvalidCommand() {
		String input="abcd";
		
		assertEquals("invalid command format :abcd",CityConnect.executeCommand(input));	
	}
	public void testEmptyCommand() {
		String input="";
		
		assertEquals("invalid command format :",CityConnect.executeCommand(input));	
	}
	
	public void testUnaddedRoute(){
		String input="getdistance aaa bbb";
		
		assertEquals("No route exists from aaa to bbb!",CityConnect.executeCommand(input));	
	}
	
	//method to simulate command line input by changing System.in to take in strings
	private void initialise(String input) {
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
	}
}
