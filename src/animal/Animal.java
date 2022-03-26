package animal;

public class Animal {

	private String nompre;
	private double peso;
	private int edad;

	public Animal(String nompre, double peso, int edad) {
		super();
		this.nompre = nompre;
		this.peso = peso;
		this.edad = edad;
	}
	
	public void sumarAnyo() {
		this.edad++;
	}
	

	public String getNompre() {
		return nompre;
	}

	public void setNompre(String nompre) {
		this.nompre = nompre;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}


	
}
