package model;

public class AutonomousCar extends Car implements ICollisionProbability {

	private double velocity;
	private double position;

	/**
	 * 
	 * @param id
	 * @param licensePlate
	 * @param model
	 * @param position
	 * @param velocity
	 */
	public AutonomousCar(String id, String licensePlate, String model, double position, double velocity) {
		super(id, licensePlate, model, velocity); 
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
	public String calculateCollisionProbability(Car car) {
		String msg = "";
		if (car instanceof AutonomousCar) {
			if (this.getPosition() == car.getPosition()) {
				msg = "Peligro, colision inminente!";
				this.velocity -= 10;
			} else {
				msg = "Los dos autos estan a una distancia segura";
			} 
		} else {
			msg = "No se puede calcular la colision porque no es un auto autonomo";
		}

		return msg;
	}

	@Override
	public String drive(double kilometers) {
		return "El vehículo autónomo se ha movilizado en:" + kilometers + "km";
	}

}
