import java.util.Random;
public class Driver {

	private String name;
	private Location location;
	private Location lastLocation;
	private int visitedSennot;

	public Driver(String name_, Location location_) {
		name = name_;
		location = location_;
		lastLocation = location_;
		visitedSennot = 0;
	}

	public String getName() {
		return name;
	}

	public Location getLocation() {
		return location;
	}

	public Location getlastLocation() {
		return lastLocation;
	}

	public int getSenCnt() {
		return visitedSennot;
	}

	// Choose which street to take given the seed which to gen a random numb from
	// and the acceptable range from which to pick the random numb
	public String chooseDest(Random rng) {


		int max = location.getStreets().size();
		lastLocation = location;

		Street street = location.getStreets().get(rng.nextInt(max));
		location = street.getDest();

		return street.getName();
	}

	public boolean checkIfSennot() {

		if (location.getName().equals("Sennot")) {
			visitedSennot++;
			return true;
		} else return false;

	}



}