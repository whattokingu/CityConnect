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
	public void testGetDistance(){
		CityConnect.setupForTesting();
		String input="addroute aaa bbb 23";
		CityConnect.executeCommand(input);
		
		input="getdistance bbb aaa";
		
		assertEquals("Distance from bbb to aaa is 23",CityConnect.executeCommand(input));	
	}
	@Test
	public void testMaxMemory(){
		CityConnect.setupForTesting();
		String input="addroute aaa bbb 23";
		CityConnect.executeCommand(input);
		//can probably do a loop
		input="addroute aab bbb 23";
		CityConnect.executeCommand(input);
		input="addroute aac bbb 23";
		CityConnect.executeCommand(input);
		input="addroute aad bbb 23";
		CityConnect.executeCommand(input);
		input="addroute aae bbb 23";
		CityConnect.executeCommand(input);
		input="addroute aaf bbb 23";
		CityConnect.executeCommand(input);
		input="addroute aag bbb 23";
		CityConnect.executeCommand(input);
		input="addroute aah bbb 23";
		CityConnect.executeCommand(input);
		input="addroute aai bbb 23";
		CityConnect.executeCommand(input);
		input="addroute aaj bbb 23";
		CityConnect.executeCommand(input);
		input="addroute aak bbb 23";

		
		assertEquals("No more space to store locations",CityConnect.executeCommand(input));	
	}
	
}


