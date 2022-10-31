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
	public String calculateCollisionProbability(Car car) {
		String msj = "";
		if (((AutonomousCar) car).getPosition() == position && ((AutonomousCar) car).getVelocity() == velocity) {
			msj = "Los dos vehiculos pueden colisionar, por favor baje la velocidad";
			setVelocity(10);

		} else {
			msj = "No hay probalidad de colision con los vehiculos";
		}
		return msj;
	}

	@Override
	public String drive(double kilometers) {
		String msj = "El vehiculo autonomo se ha movilizado en " + kilometers + " km";
		return msj;
	}

}
