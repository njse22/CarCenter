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
	public String calculateBatteryLevel(double km){
		double valueCalculation = km/100;
		double lostBattery = 0;
		if(valueCalculation>=1){
			lostBattery = valueCalculation - km%1;
		}
		double batteryLevel = this.batteryCapacity - (2*lostBattery);
		return "El nivel de bateria actual es "+batteryLevel+" KW";
	}

	@Override
	public String drive(double kilometers) {
		return "El vehiculo electrico se ha movido "+ kilometers + " km";
	}

}
