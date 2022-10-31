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
		this.position += kilometers;
		return "El vehículo autónomo "+getId()+" se ha movilizado en: "+ kilometers +" km";
	}

	@Override
	public String calculateCollisionProbability(Car car){
		String msg = "- No es posible calcular la probabilidad de colision con el vehiculo: " + car.getId() + "\n";
		if(car instanceof AutonomousCar){
			msg = "- Estas a salvo de: " + car.getId()+"\n";
			if(((AutonomousCar) car).getPosition() == this.position && ((AutonomousCar) car).getVelocity() == this.velocity){
				msg = "- Los dos vehiculos pueden colisionar, por favor baje la velocidad: "+ car.getId()+ "\n";
				velocity=velocity-10 >= 0? velocity-10:0;
			}
		}
		return msg;
	}
}
