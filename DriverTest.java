import org.junit.Test;
import java.util.Random;

import static org.junit.Assert.*;

import org.mockito.*;

public class DriverTest{
	// Tests whether a driver will choose a street they are capable of going down 
	@Test
	public void testChooseStreet(){
		long seed = 1;
		Random rng = new Random(seed);
		Driver d1 = new Driver("kevin");
		int x = rng.nextInt(3 - 1 + 1 )+ 1; 
		assertEquals( x ,d1.chooseStreet(rng, 3));
	}
}