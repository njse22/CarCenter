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

	public void carRegister(){
		String msj = "";
		System.out.println("Choose a option: \n" +
			"1)ElectricCar     2)AutonomousCar");
		int option = reader.nextInt();
		CarType carType = validateCarType(option);
		switch(carType){
			case ELECTRICCAR:
				System.out.println("Type car id:");
				String id = reader.next();
				System.out.println("Type car license plate:");
				String licensePlate = reader.next();
				System.out.println("Type car model:");
				String model = reader.next();
				System.out.println("Type car battery capacity:");
				double batteryCapacity = reader.nextDouble();
				msj = controller.createCarWithEnumeration(id, licensePlate, model, 0, 0, batteryCapacity, carType);
				break; 
			case AUTONOMOUSCAR:
				System.out.println("Type car id:");
				id = reader.next();
				System.out.println("Type car license plate:");
				licensePlate = reader.next();
				System.out.println("Type car model:");
				model = reader.next();
				System.out.println("Type car position:");
				double position = reader.nextDouble();
				System.out.println("Type car velocity:");
				double velocity = reader.nextDouble();
				msj = controller.createCarWithEnumeration(id, licensePlate, model, position, velocity, 0, carType);
				break; 
			default:
				msj = "Invalid option.";
				break; 
		}

		System.out.println(msj);

	}

	public CarType validateCarType(int option){
        CarType carType= CarType.ELECTRICCAR; 
        if(option == 1){
            carType = CarType.ELECTRICCAR;
        }
        else if(option == 2){
            carType = CarType.AUTONOMOUSCAR;
        }

        return carType;
    }

    public void calculateBatteryStatus(){
    	String msj = "Car id not registered.";
    	System.out.println("Type car id:");
		String id = reader.next();
		int pos = controller.searchCarById(id);
		if (pos != -1){
			System.out.println("Type discance traveled(km):");
			double distance = reader.nextDouble();
			msj = controller.calculateBatteryStatus(pos, distance);
		}
		System.out.println(msj);
    }

	public void executeOption(int option){
		String id = ""; 
		String licensePlate = ""; 
		String model = ""; 
		double velocity = 0; 
		double position = 0; 

		switch(option){
			case 1: 
				carRegister();

				break; 

			case 2: 
				// calcular probabilidad de colisión  

				break; 

			case 3: 
				calculateBatteryStatus();

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
