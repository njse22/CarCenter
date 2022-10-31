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
		int selection = 0;
        double km = 0;
		String msj = "";
		switch(option){
			case 1: 
			System.out.println("Escribe el id del auto");
			id = reader.next();
			System.out.println("Escribe la placa del carro");
			licensePlate = reader.next();
			System.out.println("Escribe el modelo del carro");
			model = reader.next("tipo de auto\n"+
			                    "1.Autonomo\n"+
								"2.Electrico");
			selection = reader.nextInt();
			System.out.println("Escribe la poicion del vehiculo");
            position = reader.nextDouble();
			System.out.println("Escribe la velocidad");
			velocity = reader.nextDouble();
			System.out.println("EScribe la capacidad de la bateria");
			batteryCapacity = reader.nextDouble();
			controller.createCar(id, licensePlate, model, position, velocity, batteryCapacity,selection);
				break; 

			case 2: 
				// calcular probabilidad de colisión  
                 controller.comparePosition();
				break; 

			case 3: 
				System.out.println("Escribe los kilometors recorridos");
                km = reader.nextDouble();
				msj = controller.getBatterys(km);
				System.out.println(msj);
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
