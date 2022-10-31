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
				"1. agregar un coche autonomo\n" +
				"2. Agregar un coche electrico \n" +
				"3. calcular el estado de la bateria. \n" +
				"4. calcular la probabilidad de colision. \n" +
				"0. Exit. ");
		option =  validateIntegerInput();
		return option; 
	}

	public void executeOption(int option){
		String id = ""; 
		String licensePlate = ""; 
		String model = ""; 
		double velocity = 0; 
		double position = 0; 
		double batteryCapacity = 0;
		double mileage = 0;

		switch(option){
			case 1: 
				if(controller.isFoundCar()){

					System.out.println("\nHa iniciado, registrar un coche autonomo.");

					System.out.print("\nIngresa un id para el nuevo coche autonomo: ");
					id = reader.next();

					System.out.print("\nIngresa las placas del coche autonomo: ");
					licensePlate = reader.next();

					System.out.print("\nIngresa que modelo es el coche autonomo: ");
					model = reader.next();

					System.out.print("\nIngresa cuantos KM lleva recorridos este coche autonomo: ");
					mileage = reader.nextDouble();

					System.out.print("\nIngresa la posicion inicial del coche autonomo: ");
					position = reader.nextDouble();

					System.out.print("\nIngresa la velocidad que tiene el coche autonomo: ");
					velocity = reader.nextDouble();

					System.out.println(controller.addCar(id, licensePlate, model, mileage, position, velocity)); 

				}else{
					System.out.println("\nLo sentimos, no hay mas espacio para registrar coches autonomos.");
				}

				break;


			case 2: 
				if(controller.isFoundCar()){

					System.out.println("\nHa iniciado, registrar un coche electrico.");

					System.out.print("\nIngresa un id para el nuevo coche electrico: ");
					id = reader.next();

					System.out.print("\nIngresa las placas del coche electrico: ");
					licensePlate = reader.next();

					System.out.print("\nIngresa que modelo es el coche electrico: ");
					model = reader.next();

					System.out.print("\nIngresa cuantos KM lleva recorridos este coche electrico: ");
					mileage = reader.nextDouble();

					System.out.print("\nIngresa cual es la capacidad de la bateria del coche electrico: ");
					batteryCapacity = reader.nextDouble();

					System.out.println(controller.addCar(id, licensePlate, model, mileage, batteryCapacity)); 

				}else{
					System.out.println("\nLo sentimos, no hay mas espacio para registrar coches electricos.");
				} 

				break; 

			case 3: 

				System.out.println("\nHa iniciado, calcular la bateria del coche electrico.");

				System.out.print("\nIngresa las placas del auto electrico que deseas consultar : ");
				id = reader.next();

				if(controller.searchAutonomousCar(id)==null){

					System.out.println(controller.calculateBatteryLevel(mileage));

				}

				break; 

			case 4:
			
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
