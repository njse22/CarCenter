package model;

import java.util.ArrayList;

public class CarController {

	public static final int TOTAL_CARS = 10;
	public ArrayList<Car> cars;

	public CarController() {
		cars = new ArrayList<Car>(TOTAL_CARS);
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
	public String createElectricCar(String id, String licensePlate, String model, double batteryCapacity) {
		String msg = "Vehiculo agregado con exito";

		Car newCar = new ElectricCar(id, licensePlate, model, batteryCapacity);

		cars.add(newCar);

		return msg;
	}

	public String createAutonomousCar(String id, String licensePlate, String model, double position, double velocity) {
		String msg = "";

		Car newCar = new AutonomousCar(id, licensePlate, model, position, velocity);

		cars.add(newCar);

		return msg;
	}

	public String calcProbColision() {
		String msg = "";
		int firstPos = 0;
		boolean isFirst = false;

		for (int i = 0; i < cars.size() && isFirst == false; i++) {
			if (cars.get(i) instanceof AutonomousCar) {
				firstPos = i;
				isFirst = true;
			}
		}

		for (int i = firstPos; i < cars.size(); i++) {
			if (cars.get(i) instanceof AutonomousCar) {
				msg += ((AutonomousCar)(cars.get(0))).calculateCollisionProbability(cars.get(i)) + "\n";
			}
		}

		return msg;
	}

	public String calcBatteryCapacity() {
		String msg = "";

		for (int i = 0; i < cars.size(); i++) {
			if (cars.get(i) instanceof ElectricCar) {
				msg += ((ElectricCar)(cars.get(i))).calculateBatteryLevel(100) + "\n";
			}
		}

		return msg;
	}

}
