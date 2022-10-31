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
	public String calculateBatteryLevel(double km) {
		batteryCapacity += (getBatteryCapacity()*2)/100;
		String msj = "The capacity of the batery level is: " + batteryCapacity;
		return msj;
	}

	@Override
	public String drive(double kilometers) {
		String msj = "";
		return msj;
	}

}
