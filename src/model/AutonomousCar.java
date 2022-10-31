package model;

public class AutonomousCar extends Car implements ICollisionProbability {

	private double position;
	private double velocity;

	/**
	 * 
	 * @param id
	 * @param licensePlate
	 * @param model
	 * @param position
	 * @param velocity
	 */
	public AutonomousCar(String id, String licensePlate, String model, double position, double velocity) {
		super(id, licensePlate, model); 
		this.position = position;
		this.velocity = velocity;

	}

	public double getPosition() {
		return this.position;
	}

	/**
	 * 
	 * @param position
	 */
	public void setPosition(double position) {
		this.position = position;
	}

	public double getVelocity() {
		return this.velocity;
	}

	/**
	 * 
	 * @param velocity
	 */
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	@Override
	public String drive(double kilometers){
		String msj = "El vehiculo autonomo se ha movilizado en: " + kilometers + " km";
		return msj;
	}

	public String calculateCollisionProbability(Car car){
		String msj = "";
		if(car instanceof ElectricCar){
			return msj = "No es posible calcular la probabilidad de colisión con el vehículo: " + car.getId() + "\n";
		}
		if(((AutonomousCar)car).getPosition() == this.position && ((AutonomousCar)car).getVelocity() == this.velocity){
			this.velocity = velocity - 10;
			return msj = "El vehiculo puede colosionar con el vehiculo " + car.getId() + ", por favor baje la velocidad\n";
		}
		msj = "El vehiculo no está en riesgo de colisionar con el vehiculo " + car.getId() + "\n";
		return msj;
	}

}
