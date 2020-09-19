package orquesta;

public class Cantante extends Persona implements Orquesta{
	boolean cantando;

	public Cantante() {
		super();
		this.cantando = false;
	}
	
	public Cantante(String nombre, Genero genero) {
		super(nombre, genero);
		this.cantando = false;
	}
	
	public boolean getCantando() {
		return cantando;
	}

	public void setCantando(boolean cantando) {
		this.cantando = cantando;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Cantante [");
		sb.append(super.toString());
		sb.append(", cantando=");
		sb.append(getCantando());
		sb.append("]");
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
