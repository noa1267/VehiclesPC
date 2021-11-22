package threads;

import java.util.LinkedList;


import vehicles.Vehicle;

public class Consumer implements Runnable{

	private LinkedList<Vehicle> vehiclesList;

	private final int SLEEP_MS = 1000;

	public Consumer(LinkedList<Vehicle> vehiclesList) {
		super();
		this.vehiclesList = vehiclesList;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (this){
				//the consumer waits (continue to the next iteration) while the list is empty
				if (vehiclesList.isEmpty()) {
					continue;
				}

				//when it's OK (list is not empty), the consumer retrieve the first vehicle from the list and print it
				if (vehiclesList.getFirst()==null) {
					System.out.println(Thread.currentThread().getName() + " exiting");
					break;
				}

				Vehicle vehicle = vehiclesList.removeFirst();
				System.out.println(Thread.currentThread().getName() + " consumed " + vehicle);


				//the consumer notifies the producer thread that now it can start insert
				notify();


				//for easier illustration
				try {
					Thread.sleep(SLEEP_MS);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName() + " failed to sleep - InterruptedException: " + e.toString());
				}
			}
		}
	}
}