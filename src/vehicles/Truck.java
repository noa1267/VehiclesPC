package vehicles;

import java.util.Random;

public class Truck extends Vehicle{
	private boolean cargoAttached;
	
	public Truck() {
		super();
		this.numOfWheels = 18;
		this.poweredBy = PoweredBy.Diesel;
		generateCargoAttached();
	}
	
	@Override
	public String toString() {
		return this.getClass().getName() + " [numOfWheels=" + numOfWheels + ", color=" + color + ", remainPower=" + remainPower
				+ "% , poweredBy=" + poweredBy + ", cargoAttached=" + cargoAttached + "]";
	}
	
	private void generateCargoAttached() {
		Random rd = new Random();
		this.cargoAttached = rd.nextBoolean();
	}
}
