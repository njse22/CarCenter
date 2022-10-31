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

		switch(option){
			case 1: 
				// create car 
				addCar();
				break; 

			case 2: 
				// calcular probabilidad de colisión  
				calculateCollisionProbability();
				break; 

			case 3: 
				// calcular capacidad de las baterias 
				calculateBatteryLevel();
				break; 

			case 0: 
				System.out.println("Exit program.");
				break; 

			default: 
				System.out.println("Invalid Option");
				break; 
		}
	}

	public void addCar(){
		System.out.println("Escribe el id del Auto");
		String id=reader.next();
		System.out.println("Escribe la placa");
		String licensePlate=reader.next();
		System.out.println("Escribe el modelo");
		String model=reader.next();
		System.out.println("Si tu auto es electrico escribe 1, de lo contrario 2");
		int option=validateIntegerInput();
		while(option>2 || option<1){
			System.out.println("Escribe una opcion valida");
			option=validateIntegerInput();
		}
		if(option==1){
			System.out.println("Escribe la capacidad de la bateria");
			double batteryCapacity= validateDoubleInput();
			while(batteryCapacity==-1){
				System.err.println("Escribe un numero");
				batteryCapacity=validateDoubleInput();
			}
			System.out.println(controller.createCar(id, licensePlate, model, 0, 0, batteryCapacity));
		}else{
			System.out.println("Escribe la posicion");
			double position=validateDoubleInput();
			while(position==-1){
				System.err.println("Escribe un numero");
				position=validateDoubleInput();
			}
			System.out.println("Escribe la velocidad");
			double velocity=validateDoubleInput();
			while(velocity==-1){
				System.err.println("Escribe un numero");
				velocity=validateDoubleInput();
			}
			System.out.println(controller.createCar(id, licensePlate, model, position, velocity, 0.0));
		}
	}

	public void calculateCollisionProbability(){
		System.out.println("Escribe el id del auto");
		String id= reader.next();
		System.out.println(controller.calculateCollisionProbability(id));
	}

	public void calculateBatteryLevel(){
		System.out.println("Escribe el id del Auto");
		String id=reader.next();
		System.out.println("Escribe el Kilometraje");
		double milage=validateDoubleInput();
		while(milage==-1){
			System.err.println("Escribe un numero");
			milage=validateDoubleInput();
		}
		System.out.println(controller.calculateBatteryLevel(id, milage));
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
