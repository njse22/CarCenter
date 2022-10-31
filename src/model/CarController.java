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
	public String createAutonomousCar(String id, String licensePlate, String model, double position, double velocity) {
		return addCar(new AutonomousCar(id,licensePlate,model,position,velocity));
	}

	public String createElectricCar(String id, String licensePlate, String model, double batteryCapacity) {
		return addCar(new ElectricCar(id,licensePlate,model,batteryCapacity));
	}

	public Car searchCarById(String id){
		Car car = null;
		for (int i = 0;i < TOTAL_CARS && car == null; i++ ) {
			if(cars[i] != null){
				if(cars[i].getId().equals(id)){
					car = cars[i];
				}
			}
		}
		return car;
	}

	public String addCar(Car car){
		String msg = "Id del vehiculo ya registrada";
		if(searchCarById(car.getId()) == null){
			msg = "Capacidad maxima alcanzada";
			boolean isAdded = false;
			for (int i = 0;i < TOTAL_CARS && !isAdded; i++ ) {
				if(cars[i] == null){
					cars[i] = car;
					isAdded = true;
					msg = "Auto anadido correctamente";
				}
			}
		}

		
		return msg;
	}

	public String calculateCollisionProbability(String id){
		String msg = "Vehiculo no encontrado o no autonomo";
		Car car = searchCarById(id);
		if(car instanceof AutonomousCar){
			msg ="";
			for(int i = 0; i < TOTAL_CARS; i++){
				if(cars[i] !=null){
					if(!cars[i].getId().equals(car.getId())){
						msg += ((AutonomousCar) car).calculateCollisionProbability(cars[i]);
					}
				}
			}
		}
		return msg;
	}

	public String calculateBatteryCapacity(double kilometers){
		String msg ="";
		for(int i = 0; i < TOTAL_CARS; i++){
			if(cars[i] != null){
				if(cars[i] instanceof ElectricCar){
					msg += ((ElectricCar) cars[i]).drive(kilometers)+ "\n";
				}else{
					msg +=   cars[i].drive(kilometers) +"\n - Este vehiculo no tiene batería \n";
				}
			}
		}
		return msg;	
	}
}
