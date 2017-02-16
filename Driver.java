import java.util.Random;
public class Driver{

	String name;
	Location position;
	Location lastPosit;
	int visitedSennot;
	
	public Driver(String name_, Location position_){
		name = name_;
		position = position_;
		lastPosit=position_;
		visitedSennot = 0;
	}

	// Choose which street to take given the seed which to gen a random numb from
	// and the acceptable range from which to pick the random numb
	public String chooseDest(Random rng){
		
		
		int max = position.connect_streets.size();
		lastPosit=position;
		
		Street street = position.connect_streets.get(rng.nextInt(max));
		position = street.dest;
		
		return street.name;
	}
	public boolean checkIfSennot(){
		if(position.name.equals("Sennot")){
			visitedSennot++;
			return true;
		}
		else return false;
	}
	
	

}