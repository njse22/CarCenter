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
		double carPos = 0, velCar = 0;
		boolean isAutonomous = false;
		String msg = "";
		boolean isOnRange = false;
		int type = 0;
		String id = ""; 
		String licensePlate = ""; 
		String model = ""; 
		double velocity = 0; 
		double position = 0; 
		double batteryCapacity = 0;
		int idPos = 0;

		switch(option){
			case 1: 
				// create car 
				System.out.println("Selecciona el tipo de carro a registrar: \n" + "1. Carro eléctrico \n" + "2. Carro autónomo");
				type = validateIntegerInput();

				isOnRange = controller.validateRange(type);

				if (isOnRange) {

					System.out.println("Ingresa el id del carro: ");
					id = reader.next();

					idPos = controller.checkCarById(id);

					if (idPos == -1) {
						System.out.println("Ingresa la placa del carro: ");
						licensePlate = reader.next();

						System.out.println("Ingresa el modelo del carro: ");	
						model = reader.next();	
					} else {
						System.out.println("Error. El id ya existe.");
					}

					switch(type) {
						case 1:
							System.out.println("Ingresa la capacidad de la batería del carro: ");
							batteryCapacity = validateDoubleInput();						
							break;

						case 2:
							System.out.println("Ingresa la posición del carro: ");
							position = validateDoubleInput();

							System.out.println("Ingresa la velocidad del carro: ");
							velocity = validateDoubleInput();

							break;
					}

					msg = controller.createCar(type, id, licensePlate, model, position, velocity, batteryCapacity);
					System.out.println(msg);
				} else {
					System.out.println("Seleccionaste una opción fuera del rango.");
				}



				break; 

			case 2: 
				// calcular probabilidad de colisión  
				System.out.println("Ingresa el id del carro: ");
				id = reader.next();

				idPos = controller.checkCarById(id);

				if(idPos != -1) {
					isAutonomous = controller.checkCarType(idPos);

					if (isAutonomous) {
						/*
						carPos = controller.getSpecificCarPosition(idPos);
						System.out.println("La posición actual del carro es de: " + carPos);

						velCar = controller.getSpecificCarVelocity(idPos);
						System.out.println("La velocidad actual del carro es de: " + velCar);
						*/

					} else {
						System.out.println("No es posible calcular la probabilidad de colisión con el vehículo: " + id);
					}

				} else {
					System.out.println("El carro no se encuentra registrado.");
				}

				break; 

			case 3: 
				// calcular capacidad de las baterias 
				System.out.println("El estado de la bateria actual de todos los vehículos es: ");
				

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
