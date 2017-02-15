public class Location{

	public String name;
	ArrayList<Street> connect_streets;

	public Location(String name_){
		name=name_;
		connect_streets = new ArrayList<Street>();
	}
	
	public boolean addStreet(Street street_){
		
		if(!checkStreet(street_.name)){
			connect_streets.add(street_);
			return true;
		}
		return false;
	
	}
	
	public boolean checkStreet(String name){
	
		for (int i =0;i<connect_streets.size() ;i++ ) {
			if(connect_streets.get(i).equals(name)) 
				return true;
		}
		return false;
	
	}
}