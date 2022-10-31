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
	public String drive(double km){
		return "The Autonomous car has driven for: " + km + " km.";
	}

	@Override
	public String calculateCollisionProbability(Car car){
		String msj = "";
		if(car instanceof AutonomousCar){
			if(getPosition() == getVelocity()){
				msj = "the two vehicles could collide, please slow down";
				setVelocity(getVelocity()-10);
			}
		}else{
			msj = "it is not possible to calculate the probability of collision with the vehicle: " + car.getId();
		}
		return msj;	
	}


}
