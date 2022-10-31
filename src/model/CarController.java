package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CarController {

	public static final int TOTAL_CARS = 10;
	public ArrayList<Car> cars; 
	

	public CarController() {
		cars = new ArrayList<>(TOTAL_CARS);
		cars.add(new AutonomousCar("1", "GTS 564", "Twingo", 5, 10));
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
		Car anyCar = null;
		
		if(carType == 1){
			ElectricCar newCar = new ElectricCar(id, licensePlate, model, batteryCapacity);
			anyCar = (Car)newCar;
		}else{
			AutonomousCar newCar = new AutonomousCar(id, licensePlate, model, position, velocity);
			anyCar = (Car)newCar;
		}
		
		return addCar(anyCar);
	}

	public String addCar(Car anyCar){
		String msj = "";

		if(cars.size()<TOTAL_CARS){
			if(cars.add(anyCar)){
				msj = "Se agrego el auto";
			}
		}else{
			msj = "La capacidad de autos esta al maximo";
		}

		return msj;
	}

	public String TotalColissionProb(){
		String msj = "Probabilidades de colision \n";
		for(int i=1; i<cars.size(); i++){
			if(cars.get(i) instanceof AutonomousCar){
				msj += "("+cars.get(i).getId()+") "+((AutonomousCar)cars.get(i)).calculateCollisionProbability(cars.get(0))+"\n";
			}else{
				msj += "No es posible calcular la probabilidad de colision con el vehiculo :"+cars.get(i).getId()+"\n";
			}
			
		}
		return msj;
	}

	





}
