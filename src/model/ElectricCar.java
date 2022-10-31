package model;

public class ElectricCar extends Car implements IBatteryNotify {

	private double batteryCapacity;
	private double batteryLevel;

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
		this.batteryLevel= batteryCapacity;
	}

	@Override
	public String calculateBatteryLevel(double milage){
		String msj="";
		double batteryDrain=(2*milage)/100;
		batteryLevel-=batteryDrain;
		msj="La bateria actual es " + batteryLevel + " %";
		return msj;
	}

	@Override
	public String drive(double kilometers){
		String msj="El auto se ha movilizado en: " + kilometers + " km";
		return msj;
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

}
