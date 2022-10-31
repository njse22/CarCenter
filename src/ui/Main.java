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
		int carType= 0;
		String licensePlate = ""; 
		String model = ""; 
		double velocity = 0; 
		double position = 0;
		double battery = 0; 
		double km = 0;


		switch(option){
			case 1: 
			System.out.println("Digit the id of the new car: ");
			id = reader.next();
			System.out.println("Digit the licensePlate: ");
			licensePlate = reader.next();
			System.out.println("Digit the model of the new car: ");
			model= reader.next();
			System.out.print("Choose the car you want to add:\n "+
			"1.Autonomous car \n" +
			"2.Electric car");
			carType = validateIntegerInput();
			if(carType == 1){
				System.out.println("Digit the position of the new car: ");
			    position = reader.nextDouble();
			    System.out.println("Digit the velocity of the new car: ");
			    velocity= reader.nextDouble();
			String msj = controller.createAutonomousCar(id, licensePlate, model, position, velocity, battery);
			System.out.println(msj);
			}else if(carType == 2){
				System.out.println("Digit the capacity of the battery: ");
				battery = reader.nextDouble();	
			String mssj	= controller.createElectricCar(id, licensePlate, model, position, velocity, battery);
			System.out.println(mssj);

			}else 
			System.out.println("Something must be wrong");

				break; 

			case 2: 
				System.out.println("Digit the id of the car:");
				id = reader.next();
				System.out.println("Write the battery capacity: ");
				km = reader.nextDouble();

				

				break; 
			case 3: 
				// calcular capacidad de las baterias 

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
