package orquesta;

public class Solista extends Cantante {

	private TipoSolista tipo;

	public Solista(String nombre, Genero genero, TipoSolista tipo) {
		super(nombre, genero);
		this.tipo = tipo;
	}

	public TipoSolista getTipo() {
		return tipo;
	}

	public void setTipo(TipoSolista tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Solista [");
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
