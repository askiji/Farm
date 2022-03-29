package granja;

import java.util.ArrayList;
import java.util.Random;

import animal.Animal;
import animal.Cerdo;
import animal.Oveja;
import animal.PeloOveja;
import animal.UsoVaca;
import animal.Vaca;
import menu.Controles;

public class Granja {

	public static  boolean pig = true;
	public static ArrayList<Animal> corral = new ArrayList<Animal>();
	public static double leche;
	public static double ganacias;
	
	public void init() {
		Vaca romera = new Vaca("Romera", 230.5, 3, UsoVaca.LECHE);
		Vaca facunda = new Vaca("Facunda", 205.2, 3 , UsoVaca.CARNE);
		Vaca fina = new Vaca("Fina", 245.4, 4, UsoVaca.LECHE);
		Cerdo petro = new Cerdo("Petro", 90.2, 2, "Rosado");
		Oveja mota = new Oveja("Mota", 40, 3, PeloOveja.RIZADO);
		Oveja coral = new Oveja("Coral", 50, 4, PeloOveja.LISO);
		Oveja cebra = new Oveja("Cebra", 37.6, 1, PeloOveja.RIZADO);
		
		corral.add(romera);
		corral.add(facunda);
		corral.add(fina);
		corral.add(petro);
		corral.add(mota);
		corral.add(coral);
		corral.add(cebra);
	}
	public void realizarAccion(int accion) {
		
		switch (accion) {
	
		case 1:
			if(hayAnimales()) {
				listadoDeAnimales();
			}
			break;
		case 2:
			if(hayAnimales()) {
				mostrarAnimal();
			}
			break;
			
		case 3:
			if(hayAnimales()) {
				sumarAnyo();
			}
			break;
		case 4:
			if (hayAnimales()) {
				bodyShame();
			}
			break;
		case 5:
			if(hayAnimales()) {
				animalMuerto();
			}
			break;
		case 6:
			if(Granja.pig) {
				System.out.println(" Ya tenemos cerdo");
			}
			else {
				anyadirCerdo();
			}
			break;
		case 7:
			if(hayAnimales()) {
				listadoCompleto();
			}
			break;
		case 8:
			if(hayVacasLecheras()) {
				obtenerLeche();
			}
			else {
				System.out.println("No hay vacas lecheras");
			}
			break;
		case 9:
			venta();
			break;

		}
	}
	
	private void venta() {
		System.out.println("Leche en stock : " + Granja.leche);
		System.out.println("Cuanta leche quiere vender");
		double venta = Controles.numberD(Granja.leche);
		System.out.println("Ganancias por esta venta " + venta/2 + " Euros");
		Granja.leche-=venta;
		System.out.println("Ganancias acumuladas " + Granja.ganacias + " Euros");
		Granja.ganacias+=venta/2;
		
		
	}
	
	private void obtenerLeche() {
		Random r = new Random();
		
		for (int i = 0; i < corral.size(); i++) {
			if(corral.get(i) instanceof Vaca) {
				Vaca aux = (Vaca) corral.get(i);
				if (aux.getUso()== UsoVaca.LECHE) {
					double cantidad = Double.valueOf((r.nextInt(50)+30)/10.0); 
					System.out.println("Leche obtenida por " + aux.getNompre() + " : " + cantidad +"l");
					Granja.leche+=cantidad;
				}
			}
		}
		
	}
	
	private boolean hayVacasLecheras() {
		for (int i = 0; i < corral.size(); i++) {
			if(corral.get(i) instanceof Vaca) {
				Vaca aux = (Vaca) corral.get(i);
				if (aux.getUso()== UsoVaca.LECHE) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private void anyadirCerdo() {
		System.out.println("Introduzca el nombre del cerdo");
		String nombre = Controles.texto();
		System.out.println("Introduzca edad");
		int edad = Controles.number(0, Integer.MAX_VALUE);
		System.out.println("Introduzca peso");
		double peso = Controles.numberD();
		System.out.println("Introduzca color de piel");
		String color = Controles.texto();
		Cerdo c1 = new Cerdo(nombre, peso, edad, color);
		corral.add(c1);
		Granja.pig=true;
	}
	
	private void animalMuerto() {
		System.out.println("MARCAR ANIMAL COMO MUERTO");
		int numero = elegirAnimal()-1;
		System.out.println("El animal "+ corral.get(numero).getNompre() + " ha murto");
		if(corral.get(numero) instanceof Cerdo) {
			Granja.pig= false;
			System.out.println("a por los wenos chorizos");
		}
		corral.remove(numero);
	}
	
	private boolean hayAnimales() {
		if (corral.size() == 0) {
			System.out.println("No hay animales");
			return false;
		}
		return true;
	}
	
	private void listadoDeAnimales() {
		System.out.println("LISTADO DE ANIMALES");
		for (int i = 0; i < corral.size(); i++) {
			System.out.println(corral.get(i).getNompre() + " : peso : " + corral.get(i).getPeso() + " Kgs, edad: " + corral.get(i).getEdad());
		}
	}
	
	private void mostrarAnimal() {
		int numero = elegirAnimal();
		System.out.println(corral.get(numero-1).getNompre() + " es " + corral.get(numero-1).getClass().getSimpleName());
		
	}
	
	private int elegirAnimal() {
		for (int i = 0; i < corral.size(); i++) {
			System.out.println(i+1+".- " + corral.get(i).getNompre());
		}	
		System.out.println("Elija animal");
		int numero = Controles.number(1,corral.size());
		return numero;
	}
	
	private void sumarAnyo() {
		System.out.println("Sumar anyo a animal");
		for (int i = 0; i < corral.size(); i++) {
			System.out.println(i+1+".- " + corral.get(i).getNompre() + " edad " + corral.get(i).getEdad() + " anyos");
		}
		System.out.println("Elija animal");
		int numero = Controles.number(1,corral.size());
		corral.get(numero-1).sumarAnyo();
		System.out.println(corral.get(numero-1).getNompre() + " tiene " + corral.get(numero-1).getEdad() + " anyos");
	}
	
	private void bodyShame() {
		System.out.println("cambiar peso animal");
		for (int i = 0; i < corral.size(); i++) {
			System.out.println(i+1+".- " + corral.get(i).getNompre() + " peso " + corral.get(i).getPeso() + " Kg");
		}
		System.out.println("Elija animal");
		int numero = Controles.number(1,corral.size());
		System.out.println("Nuevo peso");
		double peso = Controles.numberD();
		double cambio = peso-corral.get(numero-1).getPeso();
		if(cambio>=0) {
			System.out.println(corral.get(numero-1).getNompre()+ " ha ganado " + cambio + " Kg");
		}
		else {
			System.out.println(corral.get(numero-1).getNompre()+ " ha perdido " + Math.abs(cambio) + " Kg");
		}
		corral.get(numero-1).setPeso(peso);
	}
	
	private void listadoCompleto() {
		for (int i = 0; i < corral.size(); i++) {
			System.out.println(corral.get(i));
		}
	}
	
}
