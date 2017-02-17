import java.util.Random;
public class Driver{

	private String name;
	private Location position;
	private Location lastPosit;
	private int visitedSennot;
	
	public Driver(String name_, Location position_){
		name = name_;
		position = position_;
		lastPosit=position_;
		visitedSennot = 0;
	}

	public String getName() {
		return name;
	}

	// Choose which street to take given the seed which to gen a random numb from
	// and the acceptable range from which to pick the random numb
	public String chooseDest(Random rng){
		
		
		lastPosit = position;
		
		int max = position.getStreets().size();
		Street street = position.getStreets().get(rng.nextInt(max));
		position = street.getDest();
		
		return street.getName();
	}

	public String checkOutsideLocal(String road){

		if(road.equals("Fifth ave")){
			
			return  "Cleveland!";
			
		} else return "Philly!";
		
	}

	public boolean checkOutside(){

		return position.getName().equals("Outside Location");
	
	}

	public String update(String road){
		
		return name + " heading from " + lastPosit.getName() + " to " + position.getName() + " via " +road ;
	
	}
	
	public String report(String final_dest){
		
		String res = name + " has gone to " + final_dest 
		+"\n"+ name+" met with Professor Laboon " + visitedSennot + " time(s)";
		
		if(visitedSennot == 0){
			res += "\nThat student missed out!";
		}
		
		if(visitedSennot >= 3){
			res += "\nWow, that driver needed a lot of CS help!";
		} 
		
		return res + "\n-----";
	}
	
	public boolean checkIfSennot(){
		
		if(position.name.equals("Sennot")){
			visitedSennot++;
			return true;
		}
		else return false;
		
	}
	
	

}