package model;

import ui.*;

public class CarController {

	public static final int TOTAL_CARS = 10;
	public Car[] cars; 
	

	public CarController() {
		cars = new Car[ TOTAL_CARS ];
	}

	public String createElectricCar(String idElectrinc, String liscensePlate, String modelElectric, double batteryCapacity){
		String message = "No se ha podido añadir el auto.";

		boolean isCreated = false;

		for(int i = 0; i < TOTAL_CARS && !isCreated; i++){
			if(cars[i] == null){
				cars[i] = new ElectricCar(idElectrinc, liscensePlate, modelElectric, batteryCapacity);
				message = "Auto electrico añadido.";
				isCreated = true;
			}
		}

		return message;
	}

	public String createAutonomousCar(String idAuto, String liscensePlateAuto, String modelAuto, double positionAuto, double velocityAuto){
		String message = "No se ha podido añadir el auto.";
		boolean isCreated = false;

		for(int i = 0; i < TOTAL_CARS && !isCreated; i++){
			if(cars[i] == null){
				cars[i] = new AutonomousCar(idAuto, liscensePlateAuto, modelAuto, positionAuto, velocityAuto);
				message = "Auto autonomo añadido.";
				isCreated = true;
			}
		}

		return message;
	}

	public String calculateColition(String idToSearch){
		String message = "";
		int positionCar = searchCarById(idToSearch);
		if(positionCar == -1){
			message = "El auto no existe.";
		}
		else{
			if(cars[positionCar].getIsAutonomous() == true){
				message = cars[positionCar].calculateCollisionProbability(cars[positionCar]);
			}
		}

		return message;
	}

	public int searchCarById(String searched){
		int result = -1;
		boolean isFound = false;

		for(int i = 0; i < TOTAL_CARS && ! isFound; i++){
			if(cars[i] != null){
				if(cars[i].getId().equalsIgnoreCase(searched)){
					result = i;
				}
			}
		}

		return result;
	}


}
