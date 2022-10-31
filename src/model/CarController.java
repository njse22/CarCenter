package model;

import ui.*;

public class CarController {

	public static final int TOTAL_CARS = 10;
	public Car[] cars; 
	

	public CarController() {
		cars = new Car[ TOTAL_CARS ];
	}

	/**
	 * 
	 * @param id
	 * @param licensePlate
	 * @param model
	 * @param position
	 * @param velocity
	 * @param batteryCapacity
	 */
	public void createCar(String id, String licensePlate, String model, double position, double velocity, double batteryCapacity) {
		// TODO - implement CarController.createCar
		throw new UnsupportedOperationException();
	}


}
