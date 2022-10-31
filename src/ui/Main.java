package ui;

import model.*;

import java.lang.ProcessBuilder.Redirect.Type;
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
				reader.nextLine();
				System.out.println("Dime el id de este carro: ");
				id = reader.nextLine();
				System.out.println("Dime los numero de placa para este carro: ");
				licensePlate = reader.nextLine();
				System.out.println("Dime que modelo es este carro: ");
				model = reader.nextLine();
				System.out.println("Dime que tipo de carro tienes"+
				"\n 1. Carro electrico"+
				"\n 2. Carro Autonomo"+
				"\n OPcion: ");
				int type = reader.nextInt();
				switch(type){
					case 1:
						System.out.println("Dime la capacidad de bateria que tiene este carro");
						double batteryCapacity = reader.nextDouble();
						reader.nextLine();

						System.out.println(controller.createCar(id, licensePlate,model,batteryCapacity));
						break;

					case 2:
						System.out.println("Dime la posicion del carro: ");
						position = reader.nextDouble();
						reader.nextLine();
						System.out.println("Dime la velocidad de este carro: ");
						velocity = reader.nextDouble();
						reader.nextLine();
						break; 
				}
				break; 

			case 2: 
				// calcular probabilidad de colisión  
				if(controller.carAvailability().equals("No hay carros matriculados")){
					System.out.println(controller.carAvailability());
				}else{
			
					System.out.println("Dime que tipo de carro tienes"+
					"\n 1. Carro electrico"+
					"\n 2. Carro Autonomo"+
					"\n OPcion: ");
					type = reader.nextInt();
					switch(type){
						case 1:
							System.out.println("No es posible calcular la probabilidad de colision del vehiculo");
							break;
	
						case 2:
							System.out.println("Dime la posicion del carro: ");
							position = reader.nextDouble();
							reader.nextLine();
							System.out.println("Dime la velocidad de este carro: ");
							velocity = reader.nextDouble();
							reader.nextLine();
							break; 
					}
				}

				break; 

			case 3: 
				// calcular capacidad de las baterias 
				System.out.println("Dime cuantos kilometros has recorrido: ");
				double k = reader.nextDouble();
				System.out.println(controller.calculateBattery(k));

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
