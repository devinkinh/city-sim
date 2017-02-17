import java.util.Random;
import java.util.ArrayList;
// 
// javac -cp ./junit-4.12.jar;./hamcrest-core-1.3.jar;./mockito-core-1.10.19.jar;./objenesis-2.4.jar; *.java
//
public class  CitySim9004{

	private City city;
	private Random rng;

	public CitySim9004(Random rng_){

		rng = rng_;
		city = new City("pittsburgh");

	}
	

	public Driver[] genDrivers(int numDrivers){
		
		Driver[] res = new Driver[numDrivers];
		for(int i = 0;i < numDrivers; i++){
			
			res[i] = new Driver(("Driver "+(i+1)),  city.randomLocInCity(rng)); // set up initial position
		
		}
		return res;


	}
		
	public void run(){
		
		String road= "";
		Driver[] driver = genDrivers(5);
		
		for(int i = 0;i < driver.length; i++){
			
			driver[i].checkIfSennot();
			while(!driver[i].checkOutside()){ 
				
				road = driver[i].chooseDest(rng);  
				driver[i].checkIfSennot();
				System.out.println(driver[i].update(road));
				
			}
			
			System.out.println(driver[i].report(driver[i].checkOutsideLocal(road)));
			
		}
	}
	
	public static void main(String[] args) {
		
		int god_seed = Integer.parseInt(args[0]);
		Random rng = new Random(god_seed);
		
		CitySim9004 city_sim = new CitySim9004(rng);
		city_sim.run();
		
	
	}
}