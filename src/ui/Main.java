package ui;

import model.*;
import java.util.Scanner;

public class Main {

	private CarController controller;
	private Scanner reader;

	public Main() {
		controller = new CarController();
		reader = new Scanner(System.in);

	}

	public static void main(String[] args) {

		// creación del objeto. 
		Main main = new Main(); 
		// llamdo a uno de los metodos de la clase. 
		int option = 0; 

		do{

			option = main.getOptionShowMenu(); 
			main.executeOption(option);

		}while(option != 0);

		main.getReader().close();

	}

	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println("<<<<< Welcome to Store >>>>>");
		System.out.println(
				"1. agregar un carro nuevo\n" +
				"2. calcular probabilidad de colisión \n" +
				"3. calcular estado de la bateria \n" +
				"0. Exit. ");
		option =  validateIntegerInput();
		return option; 
	}

	public void executeOption(int option){
		String msj="";
		String id = ""; 
		String licensePlate = ""; 
		String model = ""; 
		double velocity = 0; 
		double position = 0; 
		double batteryCapacity=0;
		int choice=0;
		double kilometers=0;

		switch(option){
			case 1: 
				// create car 
				
				System.out.println("que auto quieres crear?\n"+
				"1. autoautonomo\n"+
				"2. autoelectrico");
				choice=reader.nextInt();
				if(choice==1){
					System.out.println("digite el id del auto");
					id=reader.next();
					msj=controller.cheackRepeatidCar(id);
					if(msj.equals("")){
						System.out.println("digite la placa de la licencia");
					    licensePlate=reader.next();
					    System.out.println("digite el modelo del auto");
					    model=reader.next();
					    System.out.println("digite la posicion del vehiculo");
					    velocity=reader.nextDouble();
					    System.out.println("digite la posicion del auto");
					    position=reader.nextDouble();
						controller.createCar(id, licensePlate, model, position, velocity, batteryCapacity, choice);
					}else{
						System.out.println(msj);
					}
				}else if(choice==2){
					System.out.println("digite el id del auto");
					id=reader.next();
					msj=controller.cheackRepeatidCar(id);
					if(msj.equals("")){
						System.out.println("digite la placa de la licencia");
					    licensePlate=reader.next();
					    System.out.println("digite el modelo del auto");
					    model=reader.next();
					    System.out.println("digite la carga de la bateria del auto");
						batteryCapacity=reader.nextDouble();
						controller.createCar(id, licensePlate, model, position, velocity, batteryCapacity, choice);
					}else{
						System.out.println(msj);
					}
				}else{
					System.out.println("opcion no valida");
				}
				break; 

			case 2: 
				// calcular probabilidad de colisión  
				controller.calculateCollisionProbabilityController();
				break; 

			case 3: 
				// calcular capacidad de las baterias 
				System.out.println("digite el kilometrage para saber la bateria restante de todos los vehiculos electricos");
				kilometers=reader.nextDouble();
				controller.calculateBatteryLevel(kilometers);
				

				break; 

			case 0: 
				System.out.println("Exit program.");
				break; 

			default: 
				System.out.println("Invalid Option");
				break; 
		}
	}

	public Scanner getReader(){
		return reader; 
	}

	public int validateIntegerInput(){
		int option = 0; 

		if(reader.hasNextInt()){
			option = reader.nextInt(); 
		}
		else{
			// clear reader. 
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}

	public double validateDoubleInput(){
		double option = 0; 

		if(reader.hasNextDouble()){
			option = reader.nextDouble(); 
		}
		else{
			// clear reader. 
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}



}
