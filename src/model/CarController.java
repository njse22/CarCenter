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
	public String createAutonomousCar(String id, String licensePlate, String model, double position, double velocity){
		String msj = "Maximun capacity reached";
		boolean isFound = false;
		Car newAutonomousCar = new AutonomousCar(id, licensePlate, model, position, velocity);
		for(int i = 0; i < TOTAL_CARS && !isFound;i++){
			if(cars[i] == null){
				cars[i] = newAutonomousCar;
				isFound = true;
				msj = "The autonomous car was added succesfully";
			}
		}
		return msj;
	}

	public String createElectricCar(String id, String licensePlate, String model, double batteryCapacity){
		String msj = "Maximun capacity reached";
		boolean isFound = false;
		Car newElectricCar = new ElectricCar(id, licensePlate,model,batteryCapacity);
		for(int i = 0; i < TOTAL_CARS && !isFound;i++){
			if(cars[i] == null){
				cars[i] = newElectricCar;
				isFound = true;
				msj = "The Electric car was added succesfully";
			}
		}
		return msj;
	}

	public String calculateColision(){
		String msj = "";
		boolean isFound = false;
		for (int i = 1;i < TOTAL_CARS; i++ ){
			if(cars[i] != null){
				if(cars[0] instanceof AutonomousCar){
					msj += ((AutonomousCar)(cars[0])).calculateCollisionProbability(cars[i]) + "\n";	
				}
			}
		}
		return msj;
	}


}
