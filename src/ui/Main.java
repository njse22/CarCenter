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
		switch(option) {
			case 1:
				// create car
				System.out.print("Type car 0(Autonomous) 1(Electric): ");
				int typeCar  = reader.nextInt();
				System.out.print("Id: ");
				id = reader.next();
				System.out.print("License Plate: ");
				licensePlate = reader.next();
				System.out.print("Model: ");
				model = reader.next();

				switch (typeCar) {
					case 0 -> {
						position = reader.nextDouble();
						velocity = reader.nextDouble();
						System.out.println(controller.createCar(id, licensePlate, model, position, velocity, -1));
					}
					case 1 -> {
						batteryCapacity = reader.nextDouble();
						System.out.println(controller.createCar(id, licensePlate, model, -1, -1, batteryCapacity));
					}
				}
				break; 

			case 2:


				break; 

			case 3:
				System.out.println(controller.carBatteryStatus());

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
