package model;

import ui.*;

public class CarController {

	public static final int TOTAL_CARS = 10;
	public Car[] cars;
	private double mileage; 
	

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
		
		
	}

	public boolean isFoundCar(){
        boolean isFound = false;
        for(int i=0; i<TOTAL_CARS && !isFound; i++){
            if(cars[i] == null){
                isFound = true;
            }
        }

        return isFound;
    }

	public String isAvailableCarArray(){
        String response = "\nAun quedan espacios para registrar automoviles.";
        if(cars[0]==null){
            response = "\nLo sentimos, no hay automoviles registrados.";
        }else if(cars[TOTAL_CARS-1] != null){
            response = "\nLo sentimos, has alcanzado el maximo de autos registrados en el sistema.";
        }
        return response;
    }

	public String addCar(String id, String licensePlate, String model, double mileage, double position, double velocity){
        boolean getSpace = false;
        AutonomousCar car = null;
        for(int i=0; i<TOTAL_CARS && !getSpace; i++){
            if(cars[i] == null){
                cars[i] = new AutonomousCar(id, licensePlate, model, mileage, position, velocity);
                getSpace = true;

            }
        }
        return "\nCoche autonomo agregado correctamente.\n";
    }

	public String addCar(String id, String licensePlate, String model, double mileage, double batteryCapacity){
        boolean getSpace = false;
        AutonomousCar car = null;
        for(int i=0; i<TOTAL_CARS && !getSpace; i++){
            if(cars[i] == null){
                cars[i] = new ElectricCar(id, licensePlate, model, mileage, batteryCapacity);
                getSpace = true;

            }
        }
        return "\nCoche electrico agregado correctamente.\n";
    }

	public Car searchAutonomousCar(String id){
        Car carFound = null;
        for(int i=0; i<TOTAL_CARS; i++){
            if(cars[i] !=null && cars[i].getId().equalsIgnoreCase(id)){
                carFound = cars[i];
            }
        }
        return carFound;
    }

	public String calculateBatteryLevel(double mileage) {
		double batLevel = 0;
		String msgConfirmation = null;

		batLevel = getMileage()*2/100;

		msgConfirmation = "\nLa bateria restante en este coche electrico es: " + batLevel + "KW\n";

		return msgConfirmation;
	}

	public double getMileage() {
		return this.mileage;
	}

	/**
	 * 
	 * @param id
	 */
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}


}
