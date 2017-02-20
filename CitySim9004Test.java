import java.util.Random;
import java.util.ArrayList;
import org.junit.Test;
import org.mockito.*;
import static org.junit.Assert.*;

public class CitySim9004Test{

	// Test to make sure constructor is 
	// properly initialized
	// also test city property getter method
	@Test
	public void testCitySimCosntructor(){

		CitySim9004 citySim = new CitySim9004();
		assertEquals("Pittsburgh", citySim.getCity().getName());
		assertEquals(5, citySim.getCity().getLocs().size());

	}

	// Test to check that 5 drivers,
	// driver 1, driver 2, driver 3, driver 4, driver 5,
	// are generated for simulation
	@Test
	public void checkForFiveDrivers(){

		CitySim9004 citySim = new CitySim9004();
		Random r = new Random();
		citySim.run(r);
		assertEquals("Driver 1", citySim.getDrivers()[0].getName());
		assertEquals("Driver 2", citySim.getDrivers()[1].getName());
		assertEquals("Driver 3", citySim.getDrivers()[2].getName());
		assertEquals("Driver 4", citySim.getDrivers()[3].getName());
		assertEquals("Driver 5", citySim.getDrivers()[4].getName());

	}
	// Test to make sure that the correct
	// outside location name is returned
	// when provided with the correct exit road
	@Test
	public void checkOutsideLocalWithValidRoadsTest(){
		CitySim9004 citySim = new CitySim9004();
		assertEquals("Cleveland!", citySim.checkOutsideLocal("Fifth ave"));
		assertEquals("Philly!", citySim.checkOutsideLocal("Fourth ave"));
	}
	// Test to make sure an exception is thrown if 
	// an invalid road is passed, that is anything 
	// other than 'Fifth ave' or 'Fourth ave'
	@Test(expected = IllegalArgumentException.class)
	public void checkOutsideLocalWithInvalidRoadsTest(){

		CitySim9004 citySim = new CitySim9004();
		citySim.checkOutsideLocal("Some road");

	}
	// Test sim update method to
	// make sure the right output is 
	// produced given the drivers state
	// specifically that they are going from one location
	// to another through the use of roads available to 
	// driver
	@Test
	public void testUpdateWithValidDriver(){

		CitySim9004 citySim = new CitySim9004();
		Driver driver = Mockito.mock(Driver.class);
		Location location = Mockito.mock(Location.class);
		String testRoad = "Fifth ave";
		String res = "Kevin heading from Presby to Presby via " + testRoad; 

		Mockito.when(location.getName()).thenReturn("Presby");
		Mockito.when(driver.getName()).thenReturn("Kevin");
		Mockito.when(driver.getlastLocation()).thenReturn(location);		
		Mockito.when(driver.getLocation()).thenReturn(location);

		assertEquals(res, citySim.update(driver, testRoad));		
	}

	/*********************************************

		Test sim report for expected outputs
		specifically that the right
		statements are printed given how many times a
		driver has visited sennot
 	
	*********************************************/
	// the case where driver visists 3 or more times
	@Test
	public void testReportThreeVisits(){
		CitySim9004 citySim = new CitySim9004();
		Driver driver = Mockito.mock(Driver.class);
		Location location = Mockito.mock(Location.class);
		Mockito.when(driver.getSenCnt()).thenReturn(3);
		Mockito.when(driver.getName()).thenReturn("Kevin");

		// The case where driver visits exactly 3 times
		String res =  "Kevin has gone to Cleveland!\nKevin met with Professor Laboon 3 time(s)"+
					  "\nWow, that driver needed a lot of CS help!\n-----";
		assertEquals(res, citySim.report(driver, "Cleveland!"));
		// The case where driver visits more than 3 times
		res =  "Kevin has gone to Cleveland!\nKevin met with Professor Laboon 4 time(s)"+
					  "\nWow, that driver needed a lot of CS help!\n-----";
		Mockito.when(driver.getSenCnt()).thenReturn(4);
		assertEquals(res, citySim.report(driver, "Cleveland!"));


	}
	// the case where driver visits 0 times
	@Test
	public void testReportZeroVisits(){
		CitySim9004 citySim = new CitySim9004();
		Driver driver = Mockito.mock(Driver.class);
		Location location = Mockito.mock(Location.class);
		Mockito.when(driver.getSenCnt()).thenReturn(0);
		Mockito.when(driver.getName()).thenReturn("Kevin");
		String res =  "Kevin has gone to Cleveland!\nKevin met with Professor Laboon 0 time(s)"+
					  "\nThat student missed out!\n-----";
		assertEquals(res, citySim.report(driver, "Cleveland!"));
	}
	// the case where driver visits neither 0 nor 3 or more times
	@Test
	public void testReportBetweenThreeAndZeroVisits(){
		CitySim9004 citySim = new CitySim9004();
		Driver driver = Mockito.mock(Driver.class);
		Location location = Mockito.mock(Location.class);
		Mockito.when(driver.getSenCnt()).thenReturn(1);
		Mockito.when(driver.getName()).thenReturn("Kevin");
		String res =  "Kevin has gone to Cleveland!\nKevin met with Professor Laboon 1 time(s)"+
					  "\n-----";
		assertEquals(res, citySim.report(driver, "Cleveland!"));
	}

	 /*************************************/

	 // Test to make sure that drivers 
	 // are ordered so to that they traverse the city 
	 // sequentially with Driver 1 being the first and 
	 // Driver 5 being the last
	 @Test
	 public void testDriverTraverseOrder(){
	 	CitySim9004 citySim = new CitySim9004();
	 	Random r = new Random();
	 	citySim.run(r);
	 	Driver[] drivers = citySim.getDrivers();
	 	for(int i = 0; i < drivers.length;i++){
	 		assertEquals(("Driver "+(i+1)), drivers[i].getName());
	 	}
	 }
}