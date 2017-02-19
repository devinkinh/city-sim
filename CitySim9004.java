import java.util.Random;
import java.util.ArrayList;
// windows
// javac -cp ./junit-4.12.jar;./hamcrest-core-1.3.jar;./mockito-core-1.10.19.jar;./objenesis-2.4.jar; *.java
// mac
// javac -cp ./junit-4.12.jar:./hamcrest-core-1.3.jar:./mockito-core-1.10.19.jar:./objenesis-2.4.jar: *.java
public class  CitySim9004 {

	private City city;
	private Random rng;

	public CitySim9004(Random rng_) {

		rng = rng_;
		city = new City("Pittsburgh");

	}

	public Driver[] genDrivers(int numDrivers) {

		Driver[] res = new Driver[numDrivers];
		for (int i = 0; i < numDrivers; i++) {

			res[i] = new Driver(("Driver " + (i + 1)),  city.randomLocInCity(rng)); // set up initial position

		}
		return res;


	}

	public void run() {

		String road = "";
		Driver[] driver = genDrivers(5);

		for (int i = 0; i < driver.length; i++) {

			driver[i].checkIfSennot();
			while (!driver[i].getLocation().getName().equals("Outside Location")) {

				road = driver[i].chooseDest(rng);
				driver[i].checkIfSennot();
				System.out.println(update(driver[i], road));
			}
			System.out.println(report(driver[i], checkOutsideLocal(road)));

		}
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

				CitySim9004 city_sim = new CitySim9004(rng);
				city_sim.run();

			} catch (Exception e) {
				System.out.println("An invalid argument was entered, should be an integer value");
			}

		} else if (args.length > 1) {
			System.out.println("Too many arguments were provided");
		}

	}
}