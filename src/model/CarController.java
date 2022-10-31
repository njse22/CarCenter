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
	public void createCar(String id, String licensePlate, String model, double position, double velocity, double batteryCapacity, int choice) {
		// TODO - implement CarController.createCar
		String msj="el auto no ha podido ser agregado";
		if(choice==1){
			Car newCar= new AutonomousCar(id, licensePlate, model, position, velocity);
			boolean IsEmpty=false;
            for(int i=0; i<TOTAL_CARS && !IsEmpty; i++){
              if(cars[i]==null){
                  cars[i]=newCar;
                  IsEmpty=true;
                  msj="se agrego el autoautonomo";
                }
            }
		}else if(choice==2){
			Car newCar= new ElectricCar(id, licensePlate, model, batteryCapacity);
			boolean IsEmpty=false;
            for(int i=0; i<TOTAL_CARS && !IsEmpty; i++){
              if(cars[i]==null){
                  cars[i]=newCar;
                  IsEmpty=true;
                  msj="se agrego el autoelectrico";
                }
            }
		}
		System.out.println(msj);
	}
	public String cheackRepeatidCar(String id){
       String msj="";
       boolean isFound=false;
        for(int i=0; i<TOTAL_CARS && !isFound;i++){
            if(cars[i]!=null){
                if(cars[i].getId().equals(id)){
                    msj="el id del auto esta repetido";
                    isFound=true;
                }
            }
        }
        return msj;
    }

	public void calculateCollisionProbabilityController(){
		String msj="";
		int i2=0;
		int j2=0;
		boolean isFound=false;
		double newVelocitiy=0;
		for(int i=0; i<TOTAL_CARS && isFound; i++){
			if(cars[i]!=null){
				if(cars[i] instanceof ElectricCar){
					i2=i+1;
					msj="el auto "+(i2)+" no es un autoautonomo";
					System.out.println(msj);
				}else if (cars[i] instanceof AutonomousCar){
					
					System.out.println("con respecto al auto "+ cars[i].getId()+":");
					for(int j=i; j<TOTAL_CARS;j++){
						if(cars[j]!=null){
							if(cars[j] instanceof ElectricCar){
								j2=j+1;
								msj="el auto "+(j2)+" no es un autoautonomo";
								System.out.println(msj);
							}else if (cars[j] instanceof AutonomousCar){
								if(((AutonomousCar)(cars[i])).getPosition()==((AutonomousCar)(cars[j])).getPosition()){
									if(((AutonomousCar)(cars[i])).getVelocity()==((AutonomousCar)(cars[j])).getVelocity()){
										System.out.println("hay probabilidad de colision entre el auto " + cars[i].getId()+ " y "+ cars[j].getId());
										System.out.println("se le bajara 10 km/h a la velocidad del auto "+ cars[j]);
										newVelocitiy = ((AutonomousCar)(cars[j])).calculateCollisionProbability();
										System.out.println("la nueva velocidad del auto "+cars[j].getId()+ "es: "+newVelocitiy);
									}else{
										System.out.println("no hay probabilidad de colision entre el auto " + cars[i].getId()+ " y "+ cars[j].getId());
									}
								}else{
									System.out.println("no hay probabilidad de colision entre el auto " + cars[i].getId()+ " y "+ cars[j].getId());
								}
							}else{
								System.out.println("nada");
							}

						}
					}
				}
			}
		}
	}

	public void calculateBatteryLevel(double kilometers){
		String msj="";
		double newBatery=0;
		int i2=0;
		for(int i =0; i<TOTAL_CARS;i++){
			if(cars[i]!=null){
				if(cars[i] instanceof ElectricCar){
					i2=i+1;
					newBatery=((ElectricCar)(cars[i])).calculateBatteryLevel(kilometers);
					msj="la bateria del auto "+(i2)+" seria de "+newBatery;
					System.out.println(msj);
					getDriveElectricCar(kilometers, i);
				}
			}
		}
	}

	public void getDriveElectricCar(double kilometers, int i){
		String msj="";
		msj = ((ElectricCar)(cars[i])).drive(kilometers);
		System.out.println(msj);


	}


}
