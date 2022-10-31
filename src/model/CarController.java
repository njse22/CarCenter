package model;

import ui.*;
import model.*;

public class CarController {

	public static final int TOTAL_CARS = 10;


	private Car[] cars; 
	

	public CarController() {
		cars = new Car[TOTAL_CARS];
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
	public String createCar(String id, String licensePlate, String model, double position, double velocity, double batteryCapacity, TypeOfCar carType) {
		String msj ="";		
		Car  newCar = null;
		boolean isEmpty = false;
		switch(carType){
			case AUTONOMOUSCAR:
			msj = "Car cannot be added";
        	
			newCar = new AutonomousCar(id, licensePlate, model, position, velocity);
			for(int i = 0; i <TOTAL_CARS && !isEmpty; i++){
				if(cars[i] == null){
					cars[i] = newCar; 
					isEmpty = true; 
					msj = "Car added successfully"; 
				}
			}
				break;

			case ELECTRICCAR:
			msj = "Car cannot be added";
			newCar = new ElectricCar(id, licensePlate, model, batteryCapacity);
			for(int i = 0; i <TOTAL_CARS && !isEmpty; i++){
				if(cars[i] == null){
					cars[i] = newCar; 
					isEmpty = true; 
					msj = "Car added successfully"; 
				}
			}

				break;
			default:
				msj = "Car cannot be added";
				break;
			
		}
		return msj;


	}

	public String calculateBatteryLevel(String id, double km){
		String msj = "";


		return msj;
	}

	public int searchAutonomousCarById(String id){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < TOTAL_CARS && !isFound; i++ ){
			if(cars[i] != null && cars[i].getId().equalsIgnoreCase(id)){
				pos = i; 
				isFound = true; 
				 
			}
		}
		return pos; 
	}

}
