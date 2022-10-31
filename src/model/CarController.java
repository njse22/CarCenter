package model;



public class CarController {

	public static final int TOTAL_CARS = 10;
	public Car[] cars;

	public CarController() {
		cars = new Car[TOTAL_CARS];
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
	public String createCar(String id, String licensePlate, String model, double position, double velocity,
			double batteryCapacity, String typeCar) {
		Car newCar = null;
		String msj = "";

		if (typeCar.equalsIgnoreCase("autonomo")) {
			newCar = new AutonomousCar(id, licensePlate, model, position, velocity);
			msj = addCarWithObject(newCar);
		} else if (typeCar.equalsIgnoreCase("electrico")) {
			newCar = new ElectricCar(id, licensePlate, model, batteryCapacity);
			msj = addCarWithObject(newCar);
		} else {
			msj = "Escriba un tipo de carro valido";
		}

		return msj;
	}

	public String addCarWithObject(Car newCar) {

		String msj = "Capacidad maxima alcanzada, no se pueden agregar mas carros";
		boolean isEmpty = false;
		for (int i = 0; i < TOTAL_CARS && !isEmpty; i++) {
			if (cars[i] == null) {
				cars[i] = newCar;
				isEmpty = true;
				msj = "Nuevo carro agregado";
			}
		}

		return msj;
	}

	public String getCapacityBattery(String idCar, double kilometers) {
		int posCar = searchCarById(idCar);
		String msj = "";
		String msj1 = "";
		if (posCar != -1) {
			if (cars[posCar] instanceof ElectricCar) {
				msj = ((ElectricCar) cars[posCar]).calculateBatteryLevel(kilometers);
				msj1 = cars[posCar].drive(kilometers) + "\n";
			} else {
				msj = "El id existe pero no es un carro electrico";
			}
		} else {
			msj = "El id no existe";
		}

		return msj1 + msj;
	}


	public String getCollisionProbality() {
		String msj = "";
		int firstPosAutonomous = 0;
		boolean isFound = false;
		for (int i = 0; i < TOTAL_CARS && !isFound; i++) {
			if (cars[i] != null & cars[i] instanceof AutonomousCar) {
				firstPosAutonomous = i;
				isFound = true;
			}
		}

		for (int i = 0; i < TOTAL_CARS; i++) {
			if (cars[i] != null) {
				if (cars[i] instanceof AutonomousCar) {
					msj +=  cars[firstPosAutonomous].calculateCollisionProbability(cars[i+1]);
				} else {
					msj += "No es posible calcular la colision con el vehiculo " + cars[i].getId()
							+ " Debido a que este no es un carro autonomo " + "\n" + "\n";
				}

			}

		}

		return msj;
	}

	public int searchCarById(String id) {
		int pos = -1;
		boolean isFound = false;
		for (int i = 0; i < TOTAL_CARS && !isFound; i++) {
			if (cars[i] != null) {
				if (cars[i].getId().equals(id)) {
					pos = i;
					isFound = true;
				}
			}
		}

		return pos;
	}

}
