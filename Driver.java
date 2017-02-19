import java.util.Random;
import java.lang.Exception.*;
public class Driver {

	private String name;
	private Location position;
	private Location lastPosit;
	private int visitedSennot;

	public Driver(String name_, Location position_) {
		name = name_;
		position = position_;
		lastPosit = position_;
		visitedSennot = 0;
	}

	public String getName() {
		return name;
	}
	public Location getLocation() {
		return position;
	}
	public int getSenCnt() {
		return visitedSennot;
	}

	public String chooseDest(Random rng) {

		lastPosit = position;
		int max = position.getStreets().size();
		Street street = position.getStreets().get(rng.nextInt(max));
		position = street.getDest();

		return street.getName();

	}

	public String checkOutsideLocal(String road) {

		if (road.equals("Fifth ave")) {

			return  "Cleveland!";

		} else if (road.equals("Fourth ave")) {

			return "Philly!";

		} else {

			throw new IllegalArgumentException("The road passed is not connected to any outside location");

		}

	}

	public boolean checkOutside() {

		return position.getName().equals("Outside Location");

	}

	public String update(String road)  {

		return name + " heading from " + lastPosit.getName()
		       + " to " + position.getName() + " via " + road ;

	}

	public String report(String final_dest) {

		String res = name + " has gone to " + final_dest
		             + "\n" + name + " met with Professor Laboon " + visitedSennot + " time(s)";

		if (visitedSennot == 0) {
			res += "\nThat student missed out!";
		}

		if (visitedSennot >= 3) {
			res += "\nWow, that driver needed a lot of CS help!";
		}

		return res + "\n-----";
	}

	public boolean checkIfSennot() {

		if (position.getName().equals("Sennot")) {
			visitedSennot++;
			return true;
		} else return false;

	}



}