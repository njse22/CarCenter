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
	public String createCar(String id, String licensePlate,String model, double batteryCapacity){
		String msj = "Se ha creado un carro";
		boolean isEmpty = false;
		ElectricCar owner = null;
		for(int i = 0; i<TOTAL_CARS && !isEmpty; i++){
			if(cars[i] == null){
				owner = new ElectricCar(id,licensePlate,model,batteryCapacity);
				cars[i] = owner;
			}
		}
		return msj;
	}

	public String createCar(String id,String licennsePlate, String model, double position,double velocity){
		String msj = "Se ha creado un carro";
		boolean isEmpty = false;
		AutonomousCar owner = null;
		for(int i = 0; i<TOTAL_CARS && !isEmpty; i++){
			if(cars[i] == null){
				owner = new AutonomousCar(id,licennsePlate,model,position,velocity);
				cars[i] = owner;
			}
		}
		return msj;
	}

	public String calculateBattery(double k ){
		double operation = 0;
		operation = ((k*2)/100);
		return "La bateria restante es: " +operation+"KW";
		
	}

	public String carAvailability(){
		String msj ="Posicion disponible";
		if(cars[0] == null){
			msj = "No hay carros matriculados";
		}else if(cars[TOTAL_CARS-1] != null){
			msj = "Limite de carros alcanzado";
		}
		return msj;

	}
	
	public String colitionWarning(double position, double velocity){
		String msj = "La probabilidad de colision es:";
		return msj;
	}



}
