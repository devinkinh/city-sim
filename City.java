import java.util.ArrayList;
import java.util.Random;

public class City {

	private String name;
	private ArrayList<Location> city;

	public City(String name) {
		this.name = name;
		city = new ArrayList<Location>();
		city = init_city(city);
	}
	public ArrayList<Location> init_city(ArrayList<Location> city ) {

		if (city.size() > 0 || city == null) {
			return null;
		} else {
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
		}
		return city;

	}
	public ArrayList<Location> getLocs() {

		return city;

	}
	public String getName() {

		return name;

	}
	public Location randomLocInCity(Random rng) {

		return city.get(rng.nextInt(4));

	}
	public String toString() {

		return name + " city size: " + city.size();

	}


}
