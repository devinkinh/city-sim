public class Street{
	// defined by what locations it connects, can have the same name but different srcs and dest
	public String name
	public Location dest, src;

	public Street(Locaiton src_, Locaiton dest_, String name_){
		src=src_;
		dest=dest_;
		name=name_;
	}
	
	public String getName(){
		return name;
	}
	
}