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
	public String createCar(String id, String licensePlate, String model, double position, double velocity, double batteryCapacity) {
		String msj = "no more carts can be added";
		boolean wasFound = false;
		for (int i = 0; i < cars.length && !wasFound; i++) {
			if(cars[i] != null && cars[i].getId().equalsIgnoreCase(id)){
				wasFound = true;
				msj = "the car is already registered";
			}
		}
		if(!wasFound){
			for (int i = 0; i < cars.length && !wasFound; i++) {
				if(cars[i] == null){
					if(batteryCapacity == -1){
						cars[i] = new AutonomousCar(id, licensePlate, model, position, velocity);
					}else{
						cars[i] = new ElectricCar(id, licensePlate, model, batteryCapacity);
					}
					wasFound = true;
					msj = "registered car";
				}
			}
		}
		return msj;
	}

	public String carBatteryStatus(){
		StringBuilder msj = new StringBuilder();
		for (int i = 0; i < cars.length; i++) {
			if(cars[i] != null && cars[i] instanceof ElectricCar){
				msj.append(((ElectricCar) cars[i]).calculateBatteryLevel(Math.random()*101));
			}

		}
		return msj.toString();
	}


}
