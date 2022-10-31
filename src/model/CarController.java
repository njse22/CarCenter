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
	public String createCar(String id, String licensePlate, String model, double position, double velocity, double batteryCapacity, int carType) {
		String msj = "Capacidad maxima de carros alcanzada.";
		Car car;
		if(carType == 1){
			car = new ElectricCar(id, licensePlate, model, batteryCapacity);
		} else {
			car = new AutonomousCar(id, licensePlate, model, position, velocity);
		}
		if(searchPosOfCarById(id) != -1){
			return msj = "La id ya existe";
		}
		boolean added = false;
		for(int i = 0; i < TOTAL_CARS && !added; i++){
			if(cars[i] == null){
				cars[i] = car;
				added = true;
				msj = "Carro añadido con exito.";
			}
		}
		return msj;
	}

	/**
	 * @return
	 */
	public String calculateCollisionProbability(){
		String msj = "";
		int firstAutonomousCarPos = searchFirstAutonomousCar();
		if(firstAutonomousCarPos == -1){
			return msj = "No hay carros autonomos";
		}
		for(int i = 0; i < TOTAL_CARS; i++){
			if(i != firstAutonomousCarPos){
				if(cars[i] != null){
					msj += ((AutonomousCar)cars[firstAutonomousCarPos]).calculateCollisionProbability(cars[i]);
				}
			}
		}
		return msj;
	}

	/**
	 * @param km
	 * @return
	 */
	public String calculateBatteryCapacity(double km){
		String msj = "";
		for(int i = 0; i < TOTAL_CARS; i++){
			if(cars[i] instanceof ElectricCar){
				msj += "El carro con el id " + cars[i].getId() + " quedaria con " + ((ElectricCar)cars[i]).calculateBatteryLevel(km) + " KW\n";
			}
		}
		return msj;
	}

	/**
	 * @param id
	 * @return
	 */
	public int searchPosOfCarById(String id){
		int pos = -1;
		boolean found = false;
		for(int i = 0; i < TOTAL_CARS && !found; i++){
			if(cars[i] != null){

				if(cars[i].getId().equals(id)){
					pos = i;
					found = true;
				}
			}
		}
		return pos;
	}

	/**
	 * @return
	 */
	public int searchFirstAutonomousCar(){
		int pos = -1;
		boolean found = false;
		for(int i = 0; i < TOTAL_CARS && !found; i++){
			if(cars[i] instanceof AutonomousCar){
				pos = i;
				found = true;
			}
		}
		return pos;
	}


}
