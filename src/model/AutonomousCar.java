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
	@Override
	public String drive(double kmh){
		return "El vehiculo autonomo se ha movilizado en "+kmh+" km";
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

	public String calculateCollisionProbability(Car car){
		String msj = "";
		if(car instanceof AutonomousCar){
			AutonomousCar anyCar = (AutonomousCar)car;
			if(anyCar.getPosition()==this.position && anyCar.getVelocity()==this.velocity){
				msj = "Los dos vehiculos pueden colisionar, por favor baje la velocidad";
				this.velocity = 10;
			}else{
				msj = "Los autos no pueden colisionar";
			}
		}
		return msj;
	}

}
