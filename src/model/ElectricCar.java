package model;

public class ElectricCar extends Car implements IBatteryNotify {

  private double batteryCapacity;
  private double kilometraje;

	/**
	 * 
	 * @param id
	 * @param licensePlate
	 * @param model
	 * @param batteryCapacity
   * @param kilometraje
	 */
    public ElectricCar(String id, String licensePlate, String model, double batteryCapacity, double kilometraje) {
      super(id, licensePlate, model);
      this.batteryCapacity = batteryCapacity;
      this.kilometraje = kilometraje;
    }
  
    @Override
    public String calculateBatteryLevel(double kilometraje) {
      String msj = "";
      double batteryLevel = (kilometraje * 2) / 100;
      this.batteryCapacity -= batteryLevel;
      msj = "El estado de la batería actual es " + this.batteryCapacity + " KWs";
      return msj;
    }

    public double getBatteryCapacity() {
      return this.batteryCapacity;
    }
  
    public double getKilometraje() {
      return this.kilometraje;
    }

	/**
	 * 
	 * @param batteryCapacity
	 */
	public void setBatteryCapacity(double batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

}
