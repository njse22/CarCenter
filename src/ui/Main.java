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
				"2. calcular probabilidad de colision \n" +
				"3. calcular estado de la bateria \n" +
				"0. Exit. ");
		option =  validateIntegerInput();
		return option; 
	}

	public void executeOption(int option){
		String which = "";

		switch(option){
			case 1: 
				// create car
				System.out.println("Que tipo de carro deseas agregar? \n"+
				"1. Autonomo \n"+
				"2. Electricto \n"+
				"n. Ninguno");
				which = reader.nextLine();
				if(which.equals("1")){
					createAutonomousCar();
				}else if(which.equals("2")){
					createCar();
				}else{
					System.out.println("Ok");
				}
				
				break; 

			case 2: 
				// calcular probabilidad de colisión  
				System.out.println(controller.totalColissionProb());
				break; 

			case 3: 
				// calcular capacidad de las baterias 
				System.out.println("Inserte los kilometros recorridos para calcular las baterias");
				double km = reader.nextDouble();
				if(km>0){
					System.out.println(controller.totalBatteryCalculation(km));
				}else{
					System.out.println("Los kilometros deben ser mayor a 0");
				}
				
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
			reader.nextLine();
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

	public void createCar(){
		String id = ""; 
		String licensePlate = ""; 
		String model = ""; 
		double battery = 0;
		System.out.println("Inserte el ID del carro");
		id = reader.next().trim();
		reader.nextLine();
		System.out.println("Inserte la placa del carro");
		licensePlate = reader.nextLine();
		if(licensePlate.trim().isEmpty()){
			System.out.println("La placa no puede estar vacia");
		}else{
			System.out.println("Inserte el modelo del carro");
			model = reader.nextLine();
			if(model.trim().isEmpty()){
				System.out.println("El modelo no puede estar vacio");
			}else{
				System.out.println("Inserte la capacidad de la bateria");
				battery = reader.nextDouble();	
				if (battery==0){
					System.out.println("La bateria debe ser mayor a 0");
				}else{
					System.out.println(controller.createCar(id, licensePlate, model, 0, 0, battery, 1));
				}
			}

		}
		
		
		

	}

	public void createAutonomousCar(){
		String id = ""; 
		String licensePlate = ""; 
		String model = ""; 
		double velocity = 0; 
		double position = 0; 
		System.out.println("Inserte el ID del carro");
		id = reader.next();
		reader.nextLine();
		System.out.println("Inserte la placa del carro");
		licensePlate = reader.nextLine();
		if(licensePlate.trim().isEmpty()){
			System.out.println("La placa no puede estar vacia");
		}else{
			System.out.println("Inserte el modelo del carro");
			model = reader.nextLine();
			if(model.trim().isEmpty()){
				System.out.println("El modelo no puede estar vacio");
			}else{
				System.out.println("Inserte la velocidad del carro");
				velocity = reader.nextDouble();	
				System.out.println("Inserte la posicion del carro");
				position = reader.nextDouble();
				System.out.println(controller.createCar(id, licensePlate, model, position, velocity, 0, 2));
			}
	
		}

	}



}
