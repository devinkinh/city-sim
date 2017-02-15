import java.util.Random;
public class Driver{

	String name;
	public Driver(String name_){
		name = name_;
	}

	// Choose which street to take given the seed which to gen a random numb from
	// and the acceptable range from which to pick the random numb
	public int chooseStreet(Random rng, int max){
		
		return rng.nextInt(max - 1 + 1) + 1;

	}

}