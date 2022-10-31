package model;

import ui.*;

public class CarController {

	public static final int TOTAL_CARS = 10;
	private String msj;
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
	public String createCar(String id, String licensePlate, String model, double position, double velocity, double batteryCapacity) {
		msj="El id esta repetido";
		boolean isAdded=false;
		if(searchCarById(id)==-1){
			for(int i=0;i<TOTAL_CARS && !isAdded;i++){
				msj="Capacidad Maxima Alcanzada";
				if(cars[i]==null){
					if(batteryCapacity!=0.0){
						cars[i]=new ElectricCar(id, licensePlate, model, batteryCapacity);
					}else{
						cars[i]= new AutonomousCar(id, licensePlate, model, position, velocity);
					}
					isAdded=true;
					msj="Auto agregado correctamente";
				}
			}
		}
		return msj;
	}

	public String calculateCollisionProbability(String id){
		msj="No se encontro el Auto " + id;
		if(validateAutonomousCar(id)==1){
			int collision=0;
			for(int i=0;i<TOTAL_CARS && collision!=1;i++){
				if(cars[i] instanceof AutonomousCar){
					if(cars[i].getId().equals(id)){
					}else{
						collision=((AutonomousCar)(cars[searchCarById(id)])).calculateCollisionProbability(cars[i]);
						if(collision==1){
						msj="El vehiculo podria colisionar con " + cars[i].getId() + " por favor baje la velocidad";
						}else{
						msj="No hay riesgo de Colisión continue tranquilo";
						}	
					}
				}
			}
		}else if(validateAutonomousCar(id)==0){
			msj="El Auto no es Autonomo";
		}
		return msj;
	}

	public String calculateBatteryLevel(String id, double milage){
		msj="No se encontro el Auto";
		if(validateElectricCar(id)==1){
			msj=((ElectricCar)(cars[searchCarById(id)])).calculateBatteryLevel(milage);
		}else if(validateElectricCar(id)==0){
			msj="El auto no es Electrico";
		}
		return msj;
	}

	public int validateElectricCar(String id){
		int isElectric=-1;
		if(searchCarById(id)!=-1){
			if(cars[searchCarById(id)] instanceof ElectricCar){
				isElectric=1;
			}else{
				isElectric=0;
			}
		}
		return isElectric;
	}

	public int validateAutonomousCar(String id){
		int isElectric=-1;
		if(searchCarById(id)!=-1){
			if(cars[searchCarById(id)] instanceof AutonomousCar){
				isElectric=1;
			}else{
				isElectric=0;
			}
		}
		return isElectric;
	}

	public int searchCarById(String id){
        int pos=-1;
        boolean isFound=false;
        for(int i=0;i<TOTAL_CARS && !isFound;i++){
            if(cars[i]!=null){
                if(id.equals(cars[i].getId())){
                    pos=i;
                    isFound=true;
                }
            }
        }
        return pos;
    }


}
