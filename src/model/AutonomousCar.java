package model;

public class AutonomousCar extends Car implements ICollisionProbability {

	private double position;
	private double velocity;
	private boolean isAutonomous;

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
		this.isAutonomous = true;

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

	public boolean getIsAutonomous(){
		return this.isAutonomous;
	}

	
	@Override
	public  String drive(double kilometers){
		String message = "No se puede conducir.";

		return message;
	}

	@Override
	public String calculateCollisionProbability(Car car){
		String message = "";
		boolean compareVelocity = false;
		boolean comparePosition = false;
		for(int i = 0; i < TOTAL_CARS && i < positionCar && !compareVelocity; i++){
			if(cars[i])
		}


		return message;
	}

}
