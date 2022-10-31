package model;
import model.*;

public class ElectricCar extends Car implements IBatteryNotify {

	private double batteryCapacity;

	/**
	 * 
	 * @param id
	 * @param licensePlate
	 * @param model
	 * @param batteryCapacity
	 */
	public ElectricCar(String id, String licensePlate, String model, double mileage, double batteryCapacity) {
		super(id, licensePlate,model, mileage); 
		this.batteryCapacity = batteryCapacity;

	}

	public double getBatteryCapacity() {
		return this.batteryCapacity;
	}

	/**
	 * 
	 * @param batteryCapacity
	 */
	public void setBatteryCapacity(double batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	@Override
	public String calculateBatteryLevel() {
		double batLevel = 0;
		String msgConfirmation = null;

		batLevel = getMileage()*2/100;

		msgConfirmation = "\nLa bateria restante en este coche electrico es: " + batLevel + "KW";

		return msgConfirmation;
	}

	@Override
	public String drive(double kilometers) {
		
		return null;
	}

}
