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
	public double calculateBatteryLevel(double kilometers) {
		double batteryCapacity=0;
		batteryCapacity=getBatteryCapacity()-(0.02*kilometers);
		setBatteryCapacity(batteryCapacity);
		return batteryCapacity;
	}

	@Override
	public String drive(double kilometers) {
		String msj="el auto va a "+kilometers+" kilometros por hora";
		return msj;
	}

}
