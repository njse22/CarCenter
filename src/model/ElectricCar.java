package model;

public class ElectricCar extends Car implements IBatteryNotify {

	private double batteryCapacity;

	/**
	 * 
	 * @param id
	 * @param licensePlate
	 * @param model
	 * @param batteryCapacity
	 */
	public ElectricCar(int type, String id, String licensePlate, String model, double batteryCapacity) {
		super(type, id, licensePlate,model); 
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
		double n = 1;
		double newCapacity = 0;

		double currentCapacity = getBatteryCapacity();

		newCapacity = currentCapacity - (n*2);


		setBatteryCapacity(newCapacity);

		return "Battery level is: " + newCapacity;
	}

	@Override
	public String drive(double kilometers) {
		return "El vehículo eléctrico se ha movilizado en: kmh " + kilometers;
	}

}
