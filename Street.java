public class Street {

	// defined by what locations it connects, can have the same name but different dest
	public String name;
	public Location dest;

	public Street(Location dest_, String name_) {

		dest = dest_;
		name = name_;
	}
	public Location getDest() {
		return dest;
	}
	public String getName() {
		return name;
	}

}