package model;

public class ElectricCar extends Car implements IBatteryNotify {

	private double batteryCapacity;
	private boolean isAutonomous;


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
		this.isAutonomous = false;

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
	
	public boolean getIsAutonomous(){
		return this.isAutonomous;
	}

	@Override
	public  String drive(double kilometers){
		String message = "No se puede conducir.";

		return message;
	}

	@Override
	public String calculateBatteryLevel(){
		String message = "El nivel.";

		return message;
	}


}
