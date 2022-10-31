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
		String msj = "";
		String id = ""; 
		String licensePlate = ""; 
		String model = ""; 
		double velocity = 0; 
		double position = 0; 

		switch(option){
			case 1: 

				System.out.println(" > Bienvenido, digite una identificación para el auto.");
				id = reader.next();
				System.out.println("Digita la placa: ");
				licensePlate = reader.next();
				System.out.println("Digita el modelo: ");
				model = reader.next();

				System.out.println("Ahora di que tipo de carro deseas agregar: ");
				CarType carType = validateType(reader.next());

				System.out.println("Digita: ");
				velocity = reader.nextDouble();
				System.out.println("Digita: ");
				position = reader.nextDouble();

				msj = controller.createAuto(id, licensePlate, model, option, position, velocity, null);
				System.out.println(msj);


				// create car 

				break; 

			case 2: 
				// calcular probabilidad de colisión  

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

	public CarType validateType(String carTp){

		CarType carType = CarType.AUTONOMOUSCAR;

		if(carType.equals("autonomo")){
			carType = CarType.AUTONOMOUSCAR;

		}else if(carType.equals("electrico")){
			carType = CarType.ELECTRICCAR;
		}
		return carType;
	}



}
