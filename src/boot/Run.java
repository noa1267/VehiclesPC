package boot;

import java.util.LinkedList;

import threads.Consumer;
import threads.Producer;
import vehicles.Vehicle;

public class Run {

	public static void main(String[] args) throws InterruptedException {
		LinkedList<Vehicle> vehiclesList = new LinkedList<Vehicle>();
		
		Thread producerThread = new Thread(new Producer(vehiclesList));
        producerThread.setName("producerThread");

        Thread consumerThread = new Thread(new Consumer(vehiclesList));
        consumerThread.setName("consumerThread");
        
        producerThread.start();
        consumerThread.start();
	}
}
