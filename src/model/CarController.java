package model;

import javax.sound.sampled.SourceDataLine;

import ui.*;

public class CarController {

	public static final int TOTAL_CARS = 10;
	public Car[] cars; 
	

	public CarController() {
		cars = new Car[ TOTAL_CARS ];
	}

	/**
	 * 
	 * @param id
	 * @param licensePlate
	 * @param model
	 * @param position
	 * @param velocity
	 * @param batteryCapacity
	 */
    public String createAutonomousCar(String id, String licensePlate, String model, double position, double velocity) {
      String msj = "";
      boolean wasAdded = false;
      int posCar = searchCarById(id);
      if (posCar == -1) {
        Car AutonomousCar = new AutonomousCar(id, licensePlate, model, position, velocity);
        for (int i = 0; i < cars.length && !wasAdded; i++) {
          if (cars[i] == null) {
            cars[i] = AutonomousCar;
            wasAdded = true;
            msj = "El carro fue autónomo añadido correctamente.";
          } else {
            msj = "La capacidad máxima de carros ya fue alcanzada.";
          }
        }
      } else {
        msj = "El carro ya existe en la base de datos del sistema.";
      }
      return msj;
    }

    public String createElectricCar(String id, String licensePlate, String model, double batteryCapacity,
        double kilometraje) {
      String msj = "";
      boolean wasAdded = false;
      int posCar = searchCarById(id);
      if (posCar == -1) {
        Car ElectricCar = new ElectricCar(id, licensePlate, model, batteryCapacity, kilometraje);
        for (int i = 0; i < cars.length && !wasAdded; i++) {
          if (cars[i] == null) {
            cars[i] = ElectricCar;
            wasAdded = true;
            msj = "El carro eléctrico fue añadido correctamente.";
          } else {
            msj = "La capacidad máxima de carros ya fue alcanzada.";
          }
        }
      } else {
        msj = "El carro ya existe en la base de datos del sistema.";
      }
      return msj;
    }
    
    public String calculateCurrentlyBateryLevel(String carId) {
      String msj = "";
      int posCar = searchCarById(carId);
      if (posCar != -1) {
        if (cars[posCar] instanceof ElectricCar) {
          msj = ((ElectricCar) cars[posCar]).calculateBatteryLevel(((ElectricCar) (cars[posCar])).getKilometraje());
        } else {
          msj = "El carro no es eléctrico, por lo que no se puede calcular el nivel de batería actual.";
        }
      } else {
        msj = "El carro no existe.";
      }
      return msj;
    }

    public String controllerCalculateCollisionProbability() {
      String msj = "";
      for (int i = 1; i < cars.length; i++) {
        if (cars[0] != null && cars[0] instanceof AutonomousCar) {
          cars[0].
        }
      }
    }
  
    public int searchCarById(String carId) {
      int pos = -1;
      boolean wasFound = false;
      for (int i = 0; i < cars.length && !wasFound; i++) {
        if (cars[i] != null && cars[i].getId().equalsIgnoreCase(carId)) {
          pos = i;
          wasFound = true;
        }
      }
      return pos;
    }


}
