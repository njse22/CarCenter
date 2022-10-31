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
		System.out.println();
		System.out.println("<<<<< Welcome to Autonomous Car Store >>>>>");
		System.out.println(
				"1. add a new autonomous car \n" +
				"2. add a new electric car \n" +
				"3. calculate collision probability \n" +
				"4. calculate battery status \n" +
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
		String msj = "";

		switch(option){
			case 1: 
				// add a new autonomous car
				System.out.print("Type the id of the autonomous car: ");
				id = reader.next();
				System.out.print("Type the licensePlate of the autonomous car: ");
				licensePlate = reader.next();
				System.out.print("Type the model: ");
				model = reader.next();
				System.out.print("Type the position: ");
				while (!reader.hasNextDouble()){
					reader.next();
					System.out.println("Enter a valid double number ");
				}
				position = reader.nextDouble();
				System.out.print("Type the velocity: ");
				while (!reader.hasNextDouble()){
					reader.next();
					System.out.println("Enter a valid double number ");
				}
				velocity = reader.nextDouble();
				msj = controller.createAutonomousCar(id, licensePlate, model, position, velocity);
				System.out.println(msj);
				break; 

			case 2: // add a new electric car
				System.out.print("Type the id of the electric car: ");
				id = reader.next();
				System.out.print("Type the licensePlate of the autonomous car: ");
				licensePlate = reader.next();
				System.out.print("Type the model: ");
				model = reader.next();
				System.out.print("Type the battery capacity: ");
				while (!reader.hasNextDouble()){
					reader.next();
					System.out.println("Enter a valid double number ");
				}
				batteryCapacity = reader.nextDouble();
				msj = controller.createElectricCar(id, licensePlate, model, batteryCapacity);
				System.out.println(msj); 

				break; 

			case 3: //calculate collision probability 
				msj = controller.calculateColision();
				System.out.println(msj);

				break; 

			case 4: //calculate battery status
				

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
