import java.util.Random;
import java.util.ArrayList;
import org.junit.Test;
import org.mockito.*;
import static org.junit.Assert.*;

public class LocationTest {
	// Test constructor for initialization
	// also test getters
	@Test
	public void testLocationConstructor(){
		
		Location loc = new Location("Sennot");
		assertEquals("Sennot", loc.getName());
		assertNotNull(loc.getStreets());

	}
	// Test to make sure streets are 
	// added to the location
	@Test
	public void addingLocationsTest(){
		Location loc = new Location("Sennot");
		Street street = Mockito.mock(Street.class);
		loc.addStreet(street);
		assertEquals(1, loc.getStreets().size());
	}

	
}