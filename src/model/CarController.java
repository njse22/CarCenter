package model;

import ui.*;

public class CarController {

	public static final int TOTAL_CARS = 10;
	public Car[] cars; 
	

	public CarController() {
		cars = new Car[ TOTAL_CARS ];
	}

	public boolean validateRange(int type) {
		boolean isOnRange = false;

		if(type >= 1 && type <= 2) {
			isOnRange = true;
		}

		return isOnRange;
	}

	public int checkCarById(String id) {
		int pos = -1;

		for(int i = 0; i < cars.length; i++) {
			if(cars[i] != null && cars[i].getId().equals(id)) {
				pos = i;
			}
		}

		return pos;
	}

	public boolean checkCarType(int idPos) {
		boolean isAutonomous = false; 

		if(cars[idPos].getType() == 2) {
			isAutonomous = true;
		}

		return isAutonomous;

	}

	/*
	public String calculateColision(int idPos) {
		String msg = "";
		double carPos = cars[idPos].getPosition();
		double carVel = cars[idPos].getVelocity();

		for(int i = 0; i < cars.length; i++) {

			if(cars[i] != null && cars[i].getPosition().equals(carPos) && cars[i].getVelocity().equals(carVel)) {
				msg = "los dos vehículos pueden colisionar, por favor baje la velocidad";
			}
		}

		return msg;
	}

	public void setNewVelocity(int idPos) {
		double currentV = cars[i].getVelocity();
		double newV = cars[i].getVelocity(currentV-10);
	}
	*/
	

	/**
	 * 
	 * @param id
	 * @param licensePlate
	 * @param model
	 * @param position
	 * @param velocity
	 * @param batteryCapacity
	 */
	public String createCar(int type, String id, String licensePlate, String model, double position, double velocity, double batteryCapacity) {
		String msg = "";

		switch(type) {
			case 1:
				ElectricCar newElectricC = new ElectricCar(type, id, licensePlate, model, batteryCapacity);
				msg = "Carro eléctrico registrado exitosamente.";
				break;

			case 2:
				AutonomousCar newAutonomousC = new AutonomousCar(type, id, licensePlate, model, position, velocity);
				msg = "Carro autónomo registrado exitosamente.";
				break;

		}

		return msg;
	}


}
