
import java.util.Random;
import java.util.ArrayList;
import org.junit.Test;
import org.mockito.*;
import static org.junit.Assert.*;


public class CityTest {

	// Tests the instantiation of a city object
	// checks that the city arraylist exists and is not null
	// Also checks if the city was appropriately named
	// and that 5 locations were added
	@Test
	public void CityConstructorTest() {
		City city = new City("CityTest");
		assertEquals(city.getName(), "CityTest");
		assertNotNull(city.getLocs());
		assertEquals(5, city.getLocs().size());

	}

	// test to make sure correct attribute name is returned
	@Test
	public void getNameOfCityTest() {
		City city = new City("CityTest");
		Location sennot = new Location("Sennot");
		Location l = Mockito .mock(Location.class);
		sennot.addStreet(new Street(l, "Bill st"));
		sennot.addStreet(new Street(l, "Fifth ave"));

		assertEquals(city.getName(), "CityTest");
	}

	// test to make sure valid locations are returned
	// given specific index values,
	// also ensures that the driver can not start
	// outside of the city
	@Test
	public void validLocFromRandomLocInCityTest() {

		City city = new City("CityTest");
		Random r = Mockito.mock(Random.class);
		Mockito.when(r.nextInt(4)).thenReturn(0);
		assertEquals("Presby", city.randomLocInCity(r).getName());
		Mockito.when(r.nextInt(4)).thenReturn(1);
		assertEquals("Union", city.randomLocInCity(r).getName());
		Mockito.when(r.nextInt(4)).thenReturn(2);
		assertEquals("Sennot", city.randomLocInCity(r).getName());
		Mockito.when(r.nextInt(4)).thenReturn(3);
		assertEquals("Hillman", city.randomLocInCity(r).getName());

	}

	// Test to make sure the call to toString returns the appropriate information
	@Test
	public void testToString() {
		City cityTest = new City("CityTest");
		assertEquals("CityTest city size: 5", cityTest.toString());
	}

	// Test to make sure an outside location exist on creation of the city
	// at a specific index
	@Test
	public void checkOutsideExists() {
		City city = new City("CityTest");
		assertEquals("Outside Location", city.getLocs().get(4).getName());
	}

	// test to make sure a non null list of cities is returned
	@Test
	public void getLocationsTest() {

		City cityTest = new City("CityTest");
		assertNotNull(cityTest.getLocs());

	}

	// Tests the init_city function to see if it
	// creates the right amount of locations when provided
	// an arraylist object to add locations to
	// should also return the list of locations
	@Test
	public void InitCityWithValidArrayListTest() {
		ArrayList<Location> city = new ArrayList<Location>();
		City cityTest = new City("CityTest");
		city = cityTest.init_city(city);
		assertEquals(5, city.size());
		assertNotNull(city);
	}

	// Tests the init_city function to see if that
	// nothing is created if a non empty array
	@Test
	public void InitCityWithInvalidArrayListTest() {
		ArrayList<Location> city = new ArrayList<Location>();
		Location l = Mockito.mock(Location.class);
		city.add(l);
		City cityTest = new City("CityTest");
		city = cityTest.init_city(city);
		assertNull(city);
	}

	// Test the init_city function to see if it
	// creates all the required locations
	@Test
	public void InitCityCorrectLocationTest() {

		int cnt = 0;
		City cityTest = new City("CityTest");
		ArrayList<Location> city = cityTest.getLocs();


		for (int i = 0; i < city.size(); i++) {

			if (city.get(i).getName().equals("Presby")) {

				cnt++;

			} else if (city.get(i).getName().equals("Union")) {

				cnt++;

			} else if (city.get(i).getName().equals("Sennot")) {

				cnt++;

			} else if (city.get(i).getName().equals("Hillman")) {

				cnt++;

			} else if (city.get(i).getName().equals("Outside Location")) {

				cnt++;

			}

		}

		assertEquals(5, cnt);
	}
}