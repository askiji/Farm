package animal;


public class Oveja extends Animal{
	private PeloOveja tipoPelo;

	public Oveja(String nompre, double peso, int edad, PeloOveja tipoPelo) {
		super(nompre, peso, edad);
		this.tipoPelo = tipoPelo;
	}

	public PeloOveja getTipoPelo() {
		return tipoPelo;
	}

	public void setTipoPelo(PeloOveja tipoPelo) {
		this.tipoPelo = tipoPelo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return "oveja: " + this.getNompre() +" "+ this.getPeso() + " " + this.getEdad() +" anyos uso :"  + this.getTipoPelo().toString().toLowerCase();
	}

}
