import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;


public class CityConnectTest {

	@Test
	public void testInvalidCommand() {
		CityConnect.setupForTesting();
		String input="abcd";

		assertEquals("invalid command format :abcd", CityConnect.executeCommand(input));	
	}
	
	@Test
	public void testEmptyCommand() {
		CityConnect.setupForTesting();
		String input="";
		
		assertEquals("invalid command format :",CityConnect.executeCommand(input));	
	}
	@Test @Before
	public void testUnaddedRoute(){
		CityConnect.setupForTesting();
		String input="getdistance aaa bbb";
		
		assertEquals("No route exists from aaa to bbb!",CityConnect.executeCommand(input));	
	}
	@Test
	public void testaddRoute(){
		CityConnect.setupForTesting();
		String input="addroute aaa bbb 23";
		
		assertEquals("Route from aaa to bbb with distance 23km added",CityConnect.executeCommand(input));	
	}
	@Test
	public void testgetDistance(){
		CityConnect.setupForTesting();
		String input="addroute aaa bbb 23";
		CityConnect.executeCommand(input);
		
		input="getdistance bbb aaa";
		
		assertEquals("Distance from aaa to bbb is 23",CityConnect.executeCommand(input));	
		
	}
	
}
