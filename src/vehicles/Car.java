package vehicles;

public class Car extends Vehicle{

	private String numOfDoors;
	
	public Car() {
		super();
		this.numOfWheels = 4;
		this.poweredBy = PoweredBy.Gasoline;
		this.numOfDoors = "2-5";
	}
	
	@Override
	public String toString() {
		return this.getClass().getName() + " [numOfWheels=" + numOfWheels + ", color=" + color + ", remainPower=" + remainPower
				+ "% , poweredBy=" + poweredBy + ", numOfDoors=" + numOfDoors + "]";
	}
	
}