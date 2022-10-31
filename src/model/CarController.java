package model;


import java.util.ArrayList;

public class CarController {

	public static final int TOTAL_CARS = 10;
	public ArrayList<Car> cars; 
	

	public CarController() {
		cars = new ArrayList<>(TOTAL_CARS);
		//Carro 1 para comparaciones por defecto
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
		boolean isFound = validateCar(anyCar.getId());
		if(!isFound){ 
			if(cars.size()<TOTAL_CARS){
				if(cars.add(anyCar)){
					msj = "Se agrego el auto";
				}
			}else{
				msj = "La capacidad de autos esta al maximo";
			}
		}else{
			msj = "Ya hay un carro registrado con este id";
		}
		return msj;
	}

	public String totalColissionProb(){
		String msj = "Probabilidades de colision \n";
		int contador = 0;
		for(int i=1; i<cars.size(); i++){
			if(cars.get(i) instanceof AutonomousCar){
				msj += "( Auto: "+cars.get(i).getId()+" ) "+((AutonomousCar)cars.get(i)).calculateCollisionProbability(cars.get(0))+"\n";
			}else{
				msj += "( Auto: "+cars.get(i).getId()+" ) "+"No es posible calcular la probabilidad de colision este vehiculo\n";
			}
			contador++;
		}
		if (contador == 0){
			msj = "No hay carros registrados";
		}
		return msj;
	}

	public String totalBatteryCalculation(double km){
		String msj = "Baterias a "+km+"km \n";
		int contador = 0;
		for(int i=0; i<cars.size(); i++){
			if(cars.get(i) instanceof ElectricCar){
				msj += "( Auto: "+cars.get(i).getId()+" ) "+((ElectricCar)cars.get(i)).calculateBatteryLevel(km)+"\n";
			}
			contador++;
		}
		if (contador == 0){
			msj = "No hay carros electricos registrados";
		}
		return msj;		
	}

	public boolean validateCar(String id){
		boolean isFound = false;
		for(int i=0; i<cars.size() && !isFound; i++){
			if(cars.get(i).getId().equals(id)){
				isFound = true;	
			}
		}
		return isFound;
	}


	





}
