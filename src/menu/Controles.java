package menu;

import java.util.Scanner;

public class Controles {

	public int menuPrincipal() {
		System.out.println("MENU PRINCIPAL");
		System.out.println("1.- Listado de animales");
		System.out.println("2.- Mostrar tipo de animales");
		System.out.println("3.- Sumar anyo a un animal");
		System.out.println("4.- Cambiar peso a un animal");
		System.out.println("5.- MArcar animal como muerto");
		System.out.println("6.- Adquirir nuevo cerdo");
		System.out.println("7.- Listado de animales completo");
		System.out.println("8.- Obtencion de leche");
		System.out.println("9.- Venta de leche");
		return Controles.number(1, 9);

	}
	
	public static int number(int a, int b) {
		Scanner sc = new Scanner(System.in);

		try {
			int opcion = Integer.valueOf(sc.nextLine());
			if (opcion >= a && opcion <= b) {
				return opcion;
			} else {
				System.out.println("Opcion invalida");
				return Controles.number(a, b);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Opcion invalida");
			return Controles.number(a,b);
		}	
	}
	
	public static double numberD(double d) {
		Scanner sc = new Scanner(System.in);
		try {
			double opcion = Double.valueOf(sc.nextLine());
			if(opcion>d) {
				System.out.println("No hay suficiente leche");
				return Controles.numberD(d);
			}
			else {
				return opcion;
			}
		} catch (Exception e) {
			System.out.println("Opcion invalida");
			return Controles.numberD(d);
		}
	}
	
	public static double numberD() {
		Scanner sc = new Scanner(System.in);
		try {
			double opcion = Double.valueOf(sc.nextLine());
			return opcion;
		} 
		catch (Exception e) {
			System.out.println("Esto no es un peso valido");
			return Controles.numberD();
		}
		
	}
	public static String texto() {
		Scanner sc = new Scanner(System.in);
		String texto = sc.nextLine();
		return texto;
		
	}
}
