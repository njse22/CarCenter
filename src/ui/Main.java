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
		String id = ""; 
		String licensePlate = ""; 
		String model = ""; 
		double velocity = 0; 
		double position = 0; 
		double batteryCapacity = 0;
		String msg = "";

		switch(option){
			case 1: 
				// create car 
				System.out.println("El auto es: \n" + "1. Autonomo\n" +
				"2. Electrico");

				int selection = validateIntegerInput();

				if (selection == -1) {
					System.out.println("Por favor ingrese un numero");
					break;
				}

				System.out.println("Ingrese el identificador: ");
				id = reader.next();

				System.out.println("Ingrese la placa: ");
				licensePlate = reader.next();

				System.out.println("Ingrese el modelo");
				model = reader.next();

				if (selection == 1) {
					System.out.println("Ingrese la velocidad: ");
					velocity = validateDoubleInput();

					
					System.out.println("Ingrese su posicion: ");
					position = validateDoubleInput();

					if (velocity == -1 || position == -1) {
						System.out.println("Ingrese un numero");
						break;
					}

					msg = controller.createAutonomousCar(id, licensePlate, model, position, velocity);

					System.out.println(msg);
				} else if (selection == 2){
					System.out.println("Ingrese la capacidad de bateria: ");
					batteryCapacity = validateDoubleInput();
					
					if (batteryCapacity == -1) {
						System.out.println("Por favor ingrese un numero");
						break;
					}

					msg = controller.createElectricCar(id, licensePlate, model, batteryCapacity);

					System.out.println(msg);
				} else {
					System.out.println("Seleccione correctamente el tipo de auto");
					break;
				}

				break; 

			case 2: 
				// calcular probabilidad de colisión  
				
				System.out.println(controller.calcProbColision());

				break; 

			case 3: 
				// calcular capacidad de las baterias 

				System.out.println(controller.calcBatteryCapacity());

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
