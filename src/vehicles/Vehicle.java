package vehicles;

import java.util.Random;

public abstract class Vehicle {
	protected int numOfWheels;
	protected Color color;
	protected int remainPower;
	protected PoweredBy poweredBy;
	
	
	public Vehicle() {
		this.remainPower = generateRemainPower();
		this.color = Color.getRandomColor();
	}
	

	public Vehicle(int numOfWheels, Color color, int remainPower, PoweredBy poweredBy) {
		super();
		this.numOfWheels = numOfWheels;
		this.color = color;
		this.remainPower = remainPower;
		this.poweredBy = poweredBy;
	}

	private int generateRemainPower() {
		Random rd = new Random();
	    return rd.nextInt(100) +1 ;
	}
	

	@Override
	public String toString() {
		return this.getClass().getName() + " [numOfWheels=" + numOfWheels + ", color=" + color + ", remainPower=" + remainPower
				+ "% , poweredBy=" + poweredBy + "]";
	}
	
	public enum PoweredBy{
		Electricity,
		Gasoline,
		Diesel
	}
	
	public enum Color{
		Black,
		Gray,
		Silver,
		White,
		Red,
		Blue,
		Mint,
		Brown,
		Green;
		
		public static Color getRandomColor() {
			Random random = new Random();
			return values()[random.nextInt(values().length)];
		}
	}
}
