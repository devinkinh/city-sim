import java.util.ArrayList;

public class Location {

	public String name;
	public ArrayList<Street> connect_streets;

	public Location(String name_) {
		name = name_;
		connect_streets = new ArrayList<Street>();
	}

	public void addStreet(Street street_) {

		connect_streets.add(street_);

	}
	public ArrayList<Street> getStreets() {
		return connect_streets;
	}
	public String getName() {

		return name;

	}

}