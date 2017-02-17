import java.util.ArrayList;
import java.util.Random;

public class City {
	
	String name;
	ArrayList<Location> city;
	
	public City(String name){
		this.name = name;
		city = new ArrayList<Location>();
		init_city();
	}
	public int init_city(){
		
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
		hillman.addStreet(new Street( sennot, "Fifth ave"));

		city.add(presby);
		city.add(union);
		city.add(sennot);
		city.add(hillman);
		city.add(outside);
		
		return city.size();
		
		
	}
	
	public Location randomLocInCity(Random rng){
		
		return city.get(rng.nextInt(4));
		
	}

	public String checkOutsideLocal(String road){

		if(road.equals("Fifth ave")){
				
			return  "Cleveland!";
				
		} 
		else return "Philly!";
			
	}

	public String toString(){
		
		return name+ " city size: " + city.size();
		
	}
	

}
