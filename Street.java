public class Street{
	// defined by what locations it connects, can have the same name but different srcs and dest
	public String name;
	public Location dest;

	public Street(Location dest_, String name_){
		
		dest=dest_;
		name=name_;
	}
	
	public String getName(){
		return name;
	}
	
}