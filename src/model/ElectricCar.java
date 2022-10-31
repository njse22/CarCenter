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
	public ElectricCar(String id, String licensePlate, String model, double batteryCapacity) {
		super(id, licensePlate,model); 
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
	public String drive(double km){
	return "The Electric car has driven for: " + km + " km.";
	}

	@Override
	public String calculateBatteryLevel(double km){
		double batteryRest = (km * 2)/100;
		return "The remaining battery is: " + (getBatteryCapacity() - batteryRest) + " KW";
	}
}
