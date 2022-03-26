package animal;


public class Vaca extends Animal{
	private UsoVaca uso;
	
	public Vaca(String nompre, double peso, int edad, UsoVaca uso) {
		super(nompre, peso, edad);
		this.uso = uso;
	}

	public UsoVaca getUso() {
		return uso;
	}

	public void setUso(UsoVaca uso) {
		this.uso = uso;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return "vaca: " + this.getNompre() +" "+ this.getPeso() + " " + this.getEdad() +" anyos uso :"  + this.getUso().toString().toLowerCase();
	}


}
