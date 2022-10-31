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
		// llamado a uno de los metodos de la clase. 
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
		switch(option){
			case 1: 
				createCar();
				break; 

			case 2: 
				calculateCollisionProbability();
				break; 

			case 3: 
			    calculateBatteryCapacity();
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
			reader.nextLine();
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

	public void createCar(){
		String id;
		String licensePlate;
		String model;
		double position = 0;
		double velocity = 0;
		double batteryCapacity = 0;
		int carType;
		System.out.println("Que tipo de carro deseas añadir?\n" + 
						   "1. Carro electrico\n" + 
						   "2. Carro autonomo\n");
		carType = validateIntegerInput();
		if(carType != 1 && carType != 2){
			System.out.println("Opcion invalida");
			return;
		}
		System.out.println("Ingrese el id");
		id = reader.nextLine();
		System.out.println("Ingrese la placa");
		licensePlate = reader.nextLine();
		System.out.println("Ingrese el modelo");
		model = reader.nextLine();
		switch(carType){
			case 1:
				do{
					System.out.println("Ingrese la capacidad de la bateria (KW)");
					batteryCapacity = validateDoubleInput();
				} while (batteryCapacity <= 0);
			break;

			case 2:
				do{
					System.out.println("Ingrese la posicion");
					position = validateDoubleInput();
				} while (position < 0);
				do{
					System.out.println("Ingrese la velocidad");
					velocity = validateDoubleInput();
				} while (velocity < 0);
			break;
		}
		System.out.println(controller.createCar(id, licensePlate, model, position, velocity, batteryCapacity, carType));
	}

	public void calculateCollisionProbability(){
		System.out.println(controller.calculateCollisionProbability());
	}

	public void calculateBatteryCapacity(){
		double km;
		System.out.println("Ingrese el kilometraje");
		km = validateDoubleInput();
		if(km < 0){
			System.out.println("Kilometraje incorrecto");
			return;
		}
		System.out.println(controller.calculateBatteryCapacity(km));
	}
}