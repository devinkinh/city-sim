import java.util.ArrayList;
import org.junit.Test;
import org.mockito.*;
import static org.junit.Assert.*;

public class StreetTest {
	// Test constructor for initialization
	// also test getters
	@Test
	public void testStreetConstructor(){
		Location l = Mockito.mock(Location.class);
		Street street = new Street(l, "Phil st");
		

		assertEquals("Phil St" , street.getName());
		assertNotNull(street.getDest());
	}
	// Test to valid location is 
	// returned from getters
	@Test
	public void testGettingStreetDest(){
		Location l = Mockito.mock(Location.class);
		Street street = new Street(l, "Phil st");
		Mockito.when(l.getName()).thenReturn("Presby");
		assertEquals("Presby", street.getDest().getName());

		ArrayList<Street> test = new ArrayList<Street>();
		test.add(new Street(l, "x"));
		Mockito.when(l.getStreets()).thenReturn(test);
		assertEquals(1 , street.getDest().getStreets().size());
	}

	
}