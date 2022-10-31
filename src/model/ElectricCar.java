package model;

import java.lang.Math;

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
		super(id, licensePlate,model, batteryCapacity); 
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
		return "El vehículo electrico se ha movilizado en:" + kilometers + "km";
	}

	@Override
	public String calculateBatteryLevel(double km) {
		batteryCapacity -= Math.floor(km / 100) * 2;
		return "Nivel de bateria restante: " + batteryCapacity;
	}

	

}
