package threads;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

import vehicles.Car;
import vehicles.ElectricCar;
import vehicles.ElectricMotocyle;
import vehicles.Motocyle;
import vehicles.Truck;
import vehicles.Vehicle;

public class Producer implements Runnable{
	private Map<String, Vehicle> vehiclesTypesMap;
	private LinkedList<Vehicle> vehiclesList;

	private final int SLEEP_MS = 1000;
	private final int PRODUCER_DURATION_MS = 60000; //1 minute


	public Producer(LinkedList<Vehicle> vehiclesList) {
		super();
		this.vehiclesList = vehiclesList;
		initMap();
	}


	//the producer runs for a <PRODUCER_DURATION_MS> milliseconds, generate a vehicle and insert it to the list
	@Override
	public void run() {
		long startTime = System.currentTimeMillis();

		while (System.currentTimeMillis() < startTime + PRODUCER_DURATION_MS) {
			synchronized (this){
				Vehicle vehicle = generateRandomVehicle();
				vehiclesList.add(vehicle);
				//System.out.println(Thread.currentThread().getName() + " added " + vehicle);
				
				//the producer notifies the consumer thread that now it can consume
				notify();
				
				//for easier illustration
				try {
					Thread.sleep(SLEEP_MS);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName() + " failed to sleep - InterruptedException: " + e.toString());
				}
			}
		}
		vehiclesList.add(null); //marks the end - the producer finish the job
	}

	//initialize vehiclesTypesMap with all known types
	private void initMap() {
		vehiclesTypesMap = new HashMap<String, Vehicle>();
		vehiclesTypesMap.put("Motocyle", new Motocyle());
		vehiclesTypesMap.put("Electric Motocyle", new ElectricMotocyle());
		vehiclesTypesMap.put("Car", new Car());
		vehiclesTypesMap.put("Electric Car", new ElectricCar());
		vehiclesTypesMap.put("Truck", new Truck());
	}

	//generate a random vehicle type
	private Vehicle generateRandomVehicle() {
		Object[] vehiclesNames = vehiclesTypesMap.keySet().toArray();
		String randomKey = (String) vehiclesNames[new Random().nextInt(vehiclesNames.length)];
		return vehiclesTypesMap.get(randomKey);
	}
}
