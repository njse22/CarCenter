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
	public String drive(double kilometers){
		return "El vehículo electrico "+getId()+" se ha movilizado en: "+ kilometers +" km\n" + calculateBatteryLevel(kilometers);
	}

	@Override
	public String calculateBatteryLevel(double kilometers){
		double difference = (kilometers*2)/100;
		batteryCapacity-=difference;
		return " - Desgaste de bateria de " + difference + "KW\n"+
		" - " + batteryCapacity + "KW restantes.";
	}
}
