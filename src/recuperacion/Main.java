package recuperacion;

import java.util.Scanner;

import granja.Granja;
import menu.Controles;

public class Main {
	
	/**
	 * Clase main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Granja ramonFarm = new Granja();
		ramonFarm.init();
		while (true) {
			Controles menu = new Controles();
			int opcion = menu.menuPrincipal();
			ramonFarm.realizarAccion(opcion);

			String algo = "foo";
			do {
				System.out.println("Pulse intro para volver al MENU PRINCIPAL");
				Scanner sc = new Scanner(System.in);
				algo = sc.nextLine();
			} while (!algo.equals(""));
		}
	}

}
