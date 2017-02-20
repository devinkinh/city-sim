import java.util.Random;
import java.util.ArrayList;

public class  CitySim9004 
public class  CitySim9004 {

	private City city;
	private Driver[] driver;

	public CitySim9004() {

		city = new City("Pittsburgh");

	}
	public City getCity() {
		return city;
	}
	public Driver[] getDrivers() {
		if (driver != null) {
			return driver;
		} else {
			throw new IllegalStateException("Drivers, do not exist yet, method run() should be invoked first");
		}
	}
	
	// set up initial position
	private Driver[] genDrivers(int numDrivers, Random rng) {

		Driver[] res = new Driver[numDrivers];
		for (int i = 0; i < numDrivers; i++) {

			res[i] = new Driver(("Driver " + (i + 1)),  city.randomLocInCity(rng)); 

		}
		return res;


	}

	public String run(Random rng) {

		String road = "";
		String res = "";
		driver = genDrivers(5, rng);

		for (int i = 0; i < driver.length; i++) {

			driver[i].checkIfSennot();

			while (!driver[i].getLocation().getName().equals("Outside Location")) {

				road = driver[i].chooseDest(rng);
				driver[i].checkIfSennot();
				res+= "\n" + update(driver[i], road);

			}

			res += "\n"+ report(driver[i], checkOutsideLocal(road));

		}
		return res;
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

	public String update(Driver driver, String road) {

		return driver.getName() + " heading from " + driver.getlastLocation().getName()
		       + " to " + driver.getLocation().getName() + " via " + road ;

	}

	public String report(Driver driver, String final_dest) {

		String res = driver.getName() + " has gone to " + final_dest
		             + "\n" + driver.getName() + " met with Professor Laboon " + driver.getSenCnt() + " time(s)";

		if (driver.getSenCnt() == 0) {
			res += "\nThat student missed out!";
		}

		if (driver.getSenCnt() >= 3) {
			res += "\nWow, that driver needed a lot of CS help!";
		}

		return res + "\n-----";
	}

	public static void main(String[] args) {

		if (args.length == 0) {
			System.out.println("One integer type argument must be provided");
		} else if (args.length == 1) {
			try {
				int god_seed = Integer.parseInt(args[0]);

				Random rng = new Random(god_seed);

				CitySim9004 city_sim = new CitySim9004();
				System.out.println(city_sim.run(rng));

			} catch (Exception e) {
				System.out.println("An invalid argument was entered, should be an integer value");
			}

		} else if (args.length > 1) {
			System.out.println("Too many arguments were provided");
		}

	}
}