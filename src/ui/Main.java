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
		System.out.println("\n<<<<< Welcome to Store >>>>>");
		System.out.println(
				"1. agregar un carro nuevo\n" +
				"2. calcular probabilidad de colisión \n" +
				"3. calcular estado de la bateria \n" +
				"0. Exit. ");
		option =  validateIntegerInput();
		return option; 
	}

	public void executeOption(int option){
		String id = ""; 
		String licensePlate = ""; 
		String model = ""; 
		String msg = "";
		double velocity = 0; 
		double position = 0;
		double batteryCapacity = 0;
		double kilometers = 0;

		switch(option){
			case 1: 
				// create car 
				System.out.print("Tipo de vehiculo a registrar: \n1.Electrico\n2. Autonomo\nOpcion: ");
				int choice = validateIntegerInput();

				msg = "Tipo de vehiculo invalido";
				if(choice == 1 || choice == 2){
					System.out.print("ID del vehiculo: ");
					id = getReader().next();
					System.out.print("Placa: ");
					licensePlate = getReader().next();
					System.out.print("Modelo del vehiculo: ");
					model = getReader().next();

					if(choice == 1){
						System.out.print("Capacidad de bateria: ");
						batteryCapacity = validateDoubleInput();
						msg = controller.createElectricCar(id,licensePlate,model,batteryCapacity);
					}else{
						System.out.print("Posición del vehiculo: ");
						position = validateDoubleInput();
						System.out.print("Velocidad del vehiculo: ");
						velocity = validateDoubleInput();
						msg = controller.createAutonomousCar(id,licensePlate,model,position,velocity);
					}	
				}
				
				break; 

			case 2: 
				// calcular probabilidad de colisión
				System.out.print("ID del vehiculo: ");
				id = getReader().next();

				Car car = controller.searchCarById(id);
				
				msg = "Vehiculo no encontrado";
				if(car != null){
					msg = "No es posible calcular la probabilidad de colisión de este vehiculo";
					if(car instanceof AutonomousCar){
						msg = controller.calculateCollisionProbability(car.getId());
					}
				}

				break; 

			case 3: 
				// calcular capacidad de las baterias 
				System.out.print("Distancia recorrida: ");
				kilometers = validateDoubleInput();
				msg = controller.calculateBatteryCapacity(kilometers>=0?kilometers:-kilometers);
				break; 

			case 0: 
				msg = "Exit program.";
				break; 

			default: 
				msg = "Invalid option";
				break; 
		}
		System.out.println(msg);
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
