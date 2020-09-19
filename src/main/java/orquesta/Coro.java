package orquesta;

public class Coro extends Cantante {
	private TipoCoro tipo;

	public Coro(String nombre, Genero genero, TipoCoro tipo) {
		super(nombre, genero);
		this.tipo = tipo;
	}

	public TipoCoro getTipo() {
		return tipo;
	}

	public void setTipo(TipoCoro tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Coro [");
		sb.append(super.toString());
		sb.append(", tipo=");
		sb.append(getTipo() + "]");
		return sb.toString();
	}

	@Override
	public boolean sonar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean noSonar() {
		// TODO Auto-generated method stub
		return false;
	}
}
