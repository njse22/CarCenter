package model;

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
	public void createCar(String id, String licensePlate, String model, double position, double velocity, double batteryCapacity,int selection) {
		Car newCar = null;
		boolean isEmpty = false;
		if(selection==1){
           newCar = new AutonomousCar(id,licensePlate,model,position,velocity);
		   for(int i = 0;i<TOTAL_CARS && !isEmpty;i++){
			   if(cars[i]==null){
                  cars[i]= newCar;
				  isEmpty = true;
			    }
		   }
		}else if(selection==2){
            newCar = new ElectricCar(id,licensePlate,model,batteryCapacity);
			for(int i = 0;i<TOTAL_CARS && !isEmpty;i++){
				if(cars[i]==null){
				   cars[i]= newCar;
				   isEmpty = true;
				 }
			}
		}
	}
	public String comparePosition(){
        Car firstCar = getCars()[0];
		String msj = "El primer auto no es autonomo";
		if(firstCar instanceof AutonomousCar){
		   for(int i = 1;i<TOTAL_CARS;i++){
            msj += ((AutonomousCar)(firstCar)).calculateCollisionProbability(getCars()[i])+"\n";
		   }
	   }
	   return msj;
	}
	public String getBatterys(double km){
		String msj = "";
		for(int i = 0;i<TOTAL_CARS;i++){
            if(cars[i] instanceof AutonomousCar){
               msj += ((ElectricCar)(cars[i])).calculateBatteryLevel(km)+"\n";
			}
		}
		return msj;
	}
    public Car[] getCars(){
		return this.cars;
	}

}
