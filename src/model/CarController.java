package model;

import ui.*;
import model.*;

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



	public String createAutonomousCar(String id, String licensePlate, String model, double position, double velocity, double batteryCapacity) {
		
		String msj ="";
        boolean isEmpty = false;
        Car newCar = new AutonomousCar(id, licensePlate, model, position, velocity);
        for(int i = 0; i< TOTAL_CARS && !isEmpty; i ++){
            if(cars[i]==null){
                cars[i] = newCar;
                isEmpty = true;
                msj = "The Car has been register";
            }
        }
        return msj;
		
	}

	public String createElectricCar(String id, String licensePlate, String model, double position, double velocity, double batteryCapacity){
		String msj ="";
        boolean isEmpty = false;
        Car newCar = new ElectricCar(id, licensePlate, model, batteryCapacity);
        for(int i = 0; i< TOTAL_CARS && !isEmpty; i ++){
            if(cars[i]==null){
                cars[i] = newCar;
                isEmpty = true;
                msj = "The Car has been register";
            }
        }
        return msj;
	}

	public int searchCarId(String id){
		int pos = -1;
        boolean isFound = false;
        for(int i= 0; i<TOTAL_CARS && !isFound; i++){
            if(cars[i] != null && cars[i].getId().equalsIgnoreCase(id)){
               pos = i;
               isFound = true; 
            }
        }
        return pos;
	}




}
