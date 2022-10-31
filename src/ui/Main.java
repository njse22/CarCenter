package ui;

import model.*;
import java.util.Scanner;

import javax.xml.stream.XMLOutputFactory;

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

      do {

        option = main.getOptionShowMenu();
        main.executeOption(option);

      } while (option != 0);

      main.getReader().close();

    }
  
    public void uiCreateAutonomousCar() {
      String id;
      String licensePlate;
      String model;
      double position;
      double velocity;

      System.out.println("Ingrese el ID del carro autónomo.");
      id = reader.next();
      System.out.println("Ingrese la placa del carro autónomo.");
      licensePlate = reader.next();
      System.out.println("Ingrese el modelo del carro autónomo.");
      model = reader.next();
      System.out.println("Ingrese la posición del carro autónomo.");
      position = reader.nextDouble();
      System.out.println("Ingrese la velocidad del carro autónomo.");
      velocity = reader.nextDouble();

      System.out.println(controller.createAutonomousCar(id, licensePlate, model, position, velocity));
    }

    public void uiCreateElectricCar() {
      String id;
      String licensePlate;
      String model;
      double batteryCapacity;
      double kilometraje;

      System.out.println("Ingrese el ID del carro eléctrico.");
      id = reader.next();
      System.out.println("Ingrese la placa del carro eléctrico.");
      licensePlate = reader.next();
      System.out.println("Ingrese el modelo del carro eléctrico.");
      model = reader.next();
      System.out.println("Ingrese la capacidad de la batería del carro eléctrico.");
      batteryCapacity = reader.nextDouble();
      System.out.println("Ingrese el kilometraje del carro eléctrico.");
      kilometraje = reader.nextDouble();

      System.out.println(controller.createElectricCar(id, licensePlate, model, batteryCapacity, kilometraje));
    }

    public void uiCalculateCurrentlyBateryLevel() {
      String id;

      System.out.println("Ingrese el ID del carro que quiere saber el nivel de batería actual.");
      id = reader.next();

      System.out.println(controller.calculateCurrentlyBateryLevel(id));
    }

	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println("<<<<< Welcome to Store >>>>>");
		System.out.println(
        "1. agregar un carro autónomo nuevo.\n" +
        "2. agregar un carro eléctrico nuevo. \n" +
				"3. calcular probabilidad de colisión \n" +
				"4. calcular estado de la bateria \n" +
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
        System.out.println("<<< Agregar un carro autónomo nuevo >>>");
        uiCreateAutonomousCar();
				break; 

			case 2: 
        System.out.println("<<< Agregar un carro eléctrico nuevo >>>");
        uiCreateElectricCar();
				break; 

			case 3: 
				System.out.println("<<< Calcular probabilidad de colisión >>>");

        break;

      case 4:
        System.out.println("<<< Calcular estado de la batería >>>");
      uiCalculateCurrentlyBateryLevel();
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
