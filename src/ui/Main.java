package ui;

import model.*;
import java.util.Scanner;

public class Main {

	private CarController carController;
	private Scanner reader;

	public Main() {
		carController = new CarController();
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
		int typeOfCar =0;
		String msj ="";
		String id = ""; 
		String licensePlate = ""; 
		String model = ""; 
		double velocity = 0; 
		double position = 0; 
		double batteryCapacity = 0;

		switch(option){
			case 1: 
				System.out.println("You are now adding a car");
				System.out.println("Choose which car you are creating: ");

				System.out.println("1. Autonomous car \n" +
				"2. Electric Car");
				typeOfCar = validateIntegerInput();
				if(typeOfCar == 1){
					System.out.println("Write the id of the car:");
					id = reader.next();
					System.out.println("Write the license plate of the car:");
					licensePlate = reader.next();
					System.out.println("Write the model of the car: ");
					model = reader.next();
					System.out.println("Write the velocity of the car: ");
					velocity = validateDoubleInput();
					System.out.println("Write the position of the car:");
					position = validateDoubleInput();
 
					msj = carController.createCar(id, licensePlate, model, position, velocity, position, TypeOfCar.AUTONOMOUSCAR);
					System.out.println(msj);

				}else if(typeOfCar == 2){
					System.out.println("Write the id of the car:");
					id = reader.next();
					System.out.println("Write the license plate of the car:");
					licensePlate = reader.next();
					System.out.println("Write the model of the car: ");
					model = reader.next();
					System.out.println("Write the battery capacity of the car:");
					batteryCapacity = validateDoubleInput();
					System.out.println("Write the velocity of the car: ");
					velocity = validateDoubleInput();
					System.out.println("Write the position of the car:");
					position = validateDoubleInput();

					msj = carController.createCar(id, licensePlate, model, position, velocity, batteryCapacity, TypeOfCar.ELECTRICCAR);
					System.out.println(msj);
			

				}else{
					msj = "Sorry an error happened";
					System.out.println(msj);
				}
				break; 

			case 2: 
				System.out.println("You are about to calculate the probability of colision");
				System.out.println("Write the car id: ");
				id = reader.next();


				
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
