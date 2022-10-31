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
	public String drive(double kilometers){
		String msj="El auto se ha movilizado en: " + kilometers + " km";
		return msj;
	}

	@Override
	public int calculateCollisionProbability(Car car){
		int collision=0;
		if(((AutonomousCar)(car)).getVelocity()==velocity && ((AutonomousCar)(car)).getPosition()==position){
			collision=1;
			velocity-=10;
		}
		return collision;
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

}
