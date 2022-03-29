package recuperacion;

import java.util.Scanner;

import granja.Granja;
import menu.Controles;

public class Main {

	public static void main(String[] args) {
		Granja ramonFarm = new Granja();
		ramonFarm.init();
		while (true) {
			Controles menu = new Controles();
			int opcion = menu.menuPrincipal();
			ramonFarm.realizarAccion(opcion);
			Controles.enter();
			
			
		}
	}

}
