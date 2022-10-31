package model;
import java.util.ArrayList;
import ui.*;

public class CarController {

	public static final int TOTAL_CARS = 10;
	private ArrayList<Car> cars;
	

	public CarController() {
		cars = new ArrayList<Car>(10);

		
	}

	public ArrayList<Car> getCars(){
		return cars;
	}

	public boolean addCar(Car car){
		return cars.add(car);
	}

	public String createAuto(String id, String licensePlate, String model, double batteryCapacity, double position, double velocity, CarType carType){
		
		Car newCar = null; 
		String msj = "";

		switch(carType){
			case AUTONOMOUSCAR:
				newCar = new AutonomousCar(id, licensePlate, model, position, velocity);
				msj = "Nuevo carro autonomo creado. ";
				break;
			
			case ELECTRICCAR:
				newCar = new ElectricCar(id, licensePlate, model, batteryCapacity);
				msj = "Nuevo carro electrico creado. ";
				break;
			
			default:
				msj = "Algo salió mal";
				break;
		
		}
		addCar(newCar);
		return msj;

	}





}
