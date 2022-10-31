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

		do {

			option = main.getOptionShowMenu();
			main.executeOption(option);

		} while (option != 0);

		main.getReader().close();

	}

	public int getOptionShowMenu() {
		int option = 0;
		System.out.println("<<<<< Welcome to Store >>>>>");
		System.out.println(
				"1. agregar un carro nuevo\n" +
						"2. calcular probabilidad de colisión \n" +
						"3. calcular estado de la bateria \n" +
						"0. Exit. ");
		option = validateIntegerInput();
		return option;
	}

	public void executeOption(int option) {
		String id = "";
		String licensePlate = "";
		String model = "";
		double velocity = 0;
		double position = 0;
		double batteryCapacity = 0;

		switch (option) {
			case 1:
				System.out.println("Escriba el tipo de carro que desea crear");
				String typeCar = reader.next();
				if (typeCar.equalsIgnoreCase("autonomo")) {
					System.out.println("Escriba el id del carro");
					id = reader.next();
					System.out.println("Escriba la licencia del carro");
					licensePlate = reader.next();
					System.out.println("Escriba el modelo del carro");
					model = reader.next();
					System.out.println("Escriba la posicion del carro");
					position = reader.nextDouble();
					System.out.println("Escriba la velocidad del carro");
					velocity = reader.nextDouble();

					System.out.println(controller.createCar(id, licensePlate, model, position, velocity,
							batteryCapacity, typeCar));

				} else if (typeCar.equalsIgnoreCase("electrico")) {

					System.out.println("Escriba el id del carro");
					id = reader.next();
					System.out.println("Escriba la licencia del carro");
					licensePlate = reader.next();
					System.out.println("Escriba el modelo del carro");
					model = reader.next();
					System.out.println("Escriba la capacidad de la bateria del carro");
					batteryCapacity = reader.nextDouble();

					System.out.println(controller.createCar(id, licensePlate, model, position, velocity,
							batteryCapacity, typeCar));

				} else {
					System.out.println("Escriba una opcion valida");
				}

				break;

			case 2:
				String msj = controller.getCollisionProbality();
				System.out.println(msj);

				break;

			case 3:
				System.out.println("Escriba el id del carro que desea calcular la bateria");
				id = reader.next();
				System.out.println("Escriba los kilometros recorridos");
				double kilometers = reader.nextDouble();
				msj = controller.getCapacityBattery(id, kilometers);
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

	public Scanner getReader() {
		return reader;
	}

	public int validateIntegerInput() {
		int option = 0;

		if (reader.hasNextInt()) {
			option = reader.nextInt();
		} else {
			// clear reader.
			reader.nextLine();
			option = -1;
		}

		return option;
	}

	public double validateDoubleInput() {
		double option = 0;

		if (reader.hasNextDouble()) {
			option = reader.nextDouble();
		} else {
			// clear reader.
			reader.nextLine();
			option = -1;
		}

		return option;
	}

}
