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
		String msj ="No es posible calcular la probabilidad de colision con este vehiculo; "+car.getId();
		if(car instanceof AutonomousCar){
			if( ((AutonomousCar)(car)).getPosition() == this.position && ((AutonomousCar)(car)).getVelocity() == this.velocity){
				msj = "Los dos vehiculos pueden colocionar.Es necesario bajar la velocidad";
				this.velocity = this.velocity - 10;
			}else{
				msj = "El riesgo de colision es bajo";
			}
		}
		return msj;
	}

	@Override
	public String drive(double kilometers) {
		return "El vehiculo autonomo se ha movido "+ kilometers + " km";
	}

}
