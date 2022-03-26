package animal;


public class Cerdo extends Animal {


	private String colorPiel;
	

	public Cerdo(String nompre, double peso, int edad, String colorPiel) {
		super(nompre, peso, edad);
		this.colorPiel = colorPiel;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return "cerdo: " + this.getNompre() +" "+ this.getPeso() + " " + this.getEdad() +" anyos uso :"  + this.getColorPiel();
	}
	public String getColorPiel() {
		return colorPiel;
	}
	public void setColorPiel(String colorPiel) {
		this.colorPiel = colorPiel;
	}

}
