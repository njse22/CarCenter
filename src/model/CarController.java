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
	public String createCarWithEnumeration(String id, String licensePlate, String model, double position, double velocity, double batteryCapacity, CarType carType){

		Car newCar = null; 
		String msj = "";

		switch(carType){
			case ELECTRICCAR:
				newCar = new ElectricCar(id, licensePlate, model, batteryCapacity);
				msj = addCar(newCar);
				break; 
			case AUTONOMOUSCAR:
				newCar = new AutonomousCar(id, licensePlate, model, position, velocity);
				msj = addCar(newCar);
				break; 
			default:
				msj = "Car not created.";
				break; 
		}

		return msj;
	}

	public String addCar(Car newCar){
		String msj = "Maximum capacity reached.";
		boolean isEmpty = false;
		for( int i = 0; i<TOTAL_CARS && !isEmpty; i++) {
			if(cars[i] == null){
				cars[i] = newCar;
				msj = "New car added.";
				isEmpty = true;
			}
		}
		return msj;
	}

	public int searchCarById(String carId){
		int pos = -1;
		for (int i = 0; i<TOTAL_CARS; i++){
			if(cars[i] !=null){
				if (cars[i].equals(carId)){
					pos = i;
				}
			}
		}
		return pos;
	}

	public String calculateBatteryStatus(int pos, double distance){
		String msj= "Not possible calcuate battery to autonomous car.";
		double consumeBattery = 0;
		double remainingBattery = 0;
		if (cars[pos] instanceof ElectricCar){
			(( ElectricCar )(cars[pos])).calculateBatteryLevel(distance);
			msj = "Remaining battery: " + (( ElectricCar) ( cars[pos])).getBatteryCapacity();
		}
		return msj;
	}

	/*public String addElectricCar(String id, String licensePlate, String model, double batteryCapacity){
		msj = "Maximum capacity reached.";
		Car newElectricCar = ElectricCar(String id, String licensePlate, String model, double batteryCapacity);
		for( int i = 0; i<cars.lenght; i++) {
			if(cars[i] !=null){
				cars[i] = newElectricCar;
			}
		}
		msj = "New electric"
	}*/

}
