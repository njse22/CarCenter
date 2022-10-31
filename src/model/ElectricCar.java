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
	public String drive(double kilometers) {
		String msj = "El vehiculo electrico se ha movilizado en " +kilometers +" km";
		return msj;
	}

	@Override
		public String calculateBatteryLevel(double kilometers) {
		double damageBattery = kilometers * 0.02;
		double newBattery = getBatteryCapacity() - damageBattery;
		setBatteryCapacity(newBattery);
		String msj = "El carro autonomo queda con una bateria de " +newBattery;
		return msj;

	

}

}
