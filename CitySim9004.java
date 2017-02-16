import java.util.Random;
import java.util.ArrayList;

public class CitySim9004{
	
	
	public static void main(String[] args) {
		
		int god_seed = Integer.parseInt(args[0]);
		Random rng = new Random(god_seed);
		
		Location presby = new Location("Presby");
		Location union = new Location("Union");
		Location sennot = new Location("Sennot");
		Location hillman = new Location("Hillman");
		Location outside = new Location("Outside Location");
		

				
		presby.addStreet(new Street(sennot, "Bill st"));
		presby.addStreet(new Street(union, "Fourth ave"));
		
		union.addStreet(new Street( hillman, "Phil st"));
		union.addStreet(new Street(outside, "Fourth ave"));
		
		sennot.addStreet(new Street(presby, "Bill st"));
		sennot.addStreet(new Street(outside, "Fifth ave"));
		
		hillman.addStreet(new Street(union, "Phil st"));
		hillman.addStreet(new Street( sennot, "Fifth ave"));
		
		ArrayList<Location> city = new ArrayList<Location>();
		city.add(presby);
		city.add(union);
		city.add(sennot);
		city.add(hillman);
		city.add(outside);
		
		String road="";
		for(int i = 1;i < 6; i++){
			
			Driver driver = new Driver(("Driver "+i), city.get(rng.nextInt(4))); // set up initial position
			driver.checkIfSennot();
			while(!driver.position.name.equals("Outside Location")){
				
				road = driver.chooseDest(rng);  
				driver.checkIfSennot();
				System.out.println(driver.name + " heading from " + driver.lastPosit.name + " to " + driver.position.name + " via " +road );
				
			}
			if(road.equals("Fifth ave")){
				System.out.println(driver.name+ " has gone to Cleveland!");
				
			} else System.out.println(driver.name+ " has gone to Philly!");
			
			
			System.out.println(driver.name+" met with Professor Laboon " + driver.visitedSennot + " time(s)");
			
			if(driver.visitedSennot == 0){
				System.out.println("That student missed out!");
			}
			
			if(driver.visitedSennot >= 3){
				System.out.println("Wow, that driver needed a lot of CS help!");
			} 
			
			System.out.println("-----");
			
		}
	
	}
}