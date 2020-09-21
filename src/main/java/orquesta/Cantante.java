package orquesta;

public class Cantante extends Persona implements Orquesta, Comparable<Cantante>{
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
		return false;
	}

	@Override
	public boolean noSonar() {
		return false;
	}
	
	@Override
    public int compareTo(Cantante t) {
        return this.getNombre().compareTo(t.getNombre());
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (cantando ? 1231 : 1237);
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
		Cantante other = (Cantante) obj;
		if (cantando != other.cantando)
			return false;
		return true;
	}
	
}
