import java.util.Random;
import java.util.ArrayList;
import org.junit.Test;
import org.mockito.*;
import static org.junit.Assert.*;

public class DriverTest {
	// Test driver constructor
	// also test getters
	@Test
	public void DriverConstructorTest() {
		Location l = Mockito.mock(Location.class);
		Mockito.when(l.getName()).thenReturn("local");
		Driver driver = new Driver("Kevin", l);
		assertEquals("Kevin", driver.getName());
		assertEquals("local", driver.getLocation().getName());
		assertEquals("local", driver.getlastLocation().getName());
		assertEquals(0, driver.getSenCnt());
	}

	// Test to make sure only streets that are
	// available from the current location
	// are chosen to travel through

	@Test
	public void chooseDestTest() {

		ArrayList<Location> city = new ArrayList<Location>();

		Location presby = new Location("Presby");
		Location union = new Location("Union");
		Location sennot = new Location("Sennot");
		Location hillman = new Location("Hillman");
		Location outside = new Location("Outside Location");

		presby.addStreet(new Street(sennot, "Bill st"));
		presby.addStreet(new Street(union, "Fourth ave"));

		union.addStreet(new Street(hillman, "Phil st"));
		union.addStreet(new Street(outside, "Fourth ave"));

		sennot.addStreet(new Street(presby, "Bill st"));
		sennot.addStreet(new Street(outside, "Fifth ave"));

		hillman.addStreet(new Street(union, "Phil st"));
		hillman.addStreet(new Street(sennot, "Fifth ave"));

		city.add(presby);
		city.add(union);
		city.add(sennot);
		city.add(hillman);
		city.add(outside);

		Random r = Mockito.mock(Random.class);

		Driver driver = new Driver("Kevin", presby);
		Mockito.when(r.nextInt(presby.getStreets().size())).thenReturn(0);
		assertEquals("Bill st", driver.chooseDest(r));

		driver = new Driver("Kevin", presby);
		Mockito.when(r.nextInt(presby.getStreets().size())).thenReturn(1);
		assertEquals("Fourth ave", driver.chooseDest(r));

		driver = new Driver("Kevin", union);
		Mockito.when(r.nextInt(union.getStreets().size())).thenReturn(0);
		assertEquals("Phil st", driver.chooseDest(r));
		
		driver = new Driver("Kevin", union);
		Mockito.when(r.nextInt(union.getStreets().size())).thenReturn(1);
		assertEquals("Fourth ave", driver.chooseDest(r));

		driver = new Driver("Kevin", sennot);
		Mockito.when(r.nextInt(sennot.getStreets().size())).thenReturn(0);
		assertEquals("Bill st", driver.chooseDest(r));
		
		driver = new Driver("Kevin", sennot);
		Mockito.when(r.nextInt(sennot.getStreets().size())).thenReturn(1);
		assertEquals("Fifth ave", driver.chooseDest(r));

		driver = new Driver("Kevin", hillman);
		Mockito.when(r.nextInt(hillman.getStreets().size())).thenReturn(0);
		assertEquals("Phil st", driver.chooseDest(r));
		
		driver = new Driver("Kevin", hillman);
		Mockito.when(r.nextInt(hillman.getStreets().size())).thenReturn(1);
		assertEquals("Fifth ave", driver.chooseDest(r));
		
	}
	// Test to make sure visitedSennot is incremented 
	// when driver is currently at location
	@Test
	public void checkIfSennotTest(){
		Location l = Mockito.mock(Location.class);
		Mockito.when(l.getName()).thenReturn("Sennot");
		Driver driver = new Driver("Kevin", l);
		driver.checkIfSennot();
		assertEquals(1,driver.getSenCnt());
	}
	// Test To make sure visiteSennot is not incremented
	// when driver is not at sennot
	@Test public void checkIfNotSennt(){
		Location l = Mockito.mock(Location.class);
		Mockito.when(l.getName()).thenReturn("Presby");
		Driver driver = new Driver("Kevin", l);
		driver.checkIfSennot();
		assertEquals(0,driver.getSenCnt());

	}

	
}