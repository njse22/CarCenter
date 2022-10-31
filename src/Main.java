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
				System.out.println();
				String messageOne = "";
				System.out.println("Por favor seleccione el tipo de auto que desea agregar: \n" +
				"1.Auto Electrico. \n" +
				"2.Auto Autonomo.");
				int carSelected = validateIntegerInput(); 
				if(carSelected == -1 || carSelected < 1 || carSelected > 2){
					System.out.println("Escriba una opcion valida.");
				}
				else if(carSelected == 1){
					System.out.println("Escriba el Id del auto: ");
					String idElectrinc = reader.next();
					System.out.println("Escriba la placa del auto: ");
					String liscensePlate = reader.next();
					System.out.println("Escriba el modelo del auto: ");
					String modelElectric = reader.next();
					System.out.println("Escriba el la capacidad de la bateria del auto: ");
					double batteryCapacity = validateDoubleInput();
					if( batteryCapacity == -1){
						System.out.println("Escriba una capacidad de bateria valida.");
					}
					else{
						messageOne = controller.createElectricCar(idElectrinc, liscensePlate, modelElectric, batteryCapacity);
					}
				}
				else if(carSelected == 2){
					System.out.println("Escriba el Id del auto: ");
					String idAuto = reader.next();
					System.out.println("Escriba la placa del auto: ");
					String liscensePlateAuto = reader.next();
					System.out.println("Escriba el modelo del auto: ");
					String modelAuto = reader.next();
					System.out.println("Escriba el la posicion del auto: ");
					double positionAuto = validateDoubleInput();
					if( positionAuto == -1){
						System.out.println("Escriba una posicion que sea valida.");
					}
					else{
						System.out.println("Escriba el la velocidad del auto: ");
						double velocityAuto = validateDoubleInput();
						if( velocityAuto == -1){
							System.out.println("Escriba una velocidad que sea valida.");
						}
						else{ 
							messageOne = controller.createAutonomousCar(idAuto, liscensePlateAuto, modelAuto, positionAuto, velocityAuto);
						}
					}	
				}

				System.out.println(messageOne);

				break; 

			case 2: 
				// calcular probabilidad de colisión 
				System.out.println();
				System.out.println("Por favor digite el id del vehiculo.");
				String idToSearch = reader.next();
				
				String messageTwo = controller.calculateColition(idToSearch);

				System.out.println(messageTwo);

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
