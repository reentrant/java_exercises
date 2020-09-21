package orquesta;

public class Solista extends Cantante {

	private TipoSolista tipo;

	public Solista(String nombre, Genero genero, TipoSolista tipo) {
		super(nombre, genero);
		this.tipo = tipo;
	}
	
	public Solista() {
		super();
		if (getGenero().equals(Genero.HOMBRE)) {
			this.tipo = TipoSolista.TENOR;
		} else {
			this.tipo = TipoSolista.SOPRANO;
		}
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
		sb.append("Solista: [nombre=");
		sb.append(this.getNombre());
		sb.append(", tipo=");
		sb.append(getTipo() + "]");
		return sb.toString();
	}

	@Override
	public boolean sonar() {
		boolean resultado;
		if (getCantando() == false) {
			setCantando(true);
			System.out.println("Canta un " + getTipo());
			resultado = true;
		}
		else {
			resultado = false;
		}
		return resultado;
	}

	@Override
	public boolean noSonar() {
		boolean resultado;
		if (getCantando() == true) {
			setCantando(false);
			System.out.println("Deja de cantar un " + getTipo());
			resultado = true;
		} else {
			resultado = false;
		}
		return resultado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Solista other = (Solista) obj;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
}
