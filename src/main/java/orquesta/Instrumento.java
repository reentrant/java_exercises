package orquesta;

public abstract class Instrumento implements Orquesta, Comparable<Instrumento>{

	private Persona musico;
	private boolean sonando;
	
	public Instrumento() {
		this.musico = new Persona();
		this.sonando = false;
	}
	
	public Instrumento(Persona musico) {
		this.musico = musico;
		this.sonando = false;
	}

	public Persona getMusico() {
		return musico;
	}

	public void setMusico(Persona musico) {
		this.musico = musico;
	}

	public boolean getSonando() {
		return sonando;
	}

	public void setSonando(boolean sonando) {
		this.sonando = sonando;
	}
 
	public abstract String getNombreInstrumento();
	
	@Override
	public boolean sonar() {
		boolean resultado;
		if (getSonando() == false) {
			setSonando(true);
			System.out.println("Suena un " + this.getNombreInstrumento());
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
		if (getSonando() == true) {
			setSonando(false);
			System.out.println("Deja de sonar un " + getNombreInstrumento());
			resultado = true;
		} else {
			resultado = false;
		}
		return resultado;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[musico=");
		sb.append(getMusico());
		sb.append(", sonando=");
		sb.append(getSonando());
		sb.append("]");
		return sb.toString();
	}
	
	@Override
    public int compareTo(Instrumento t) {
        return this.getNombreInstrumento().compareTo(t.getNombreInstrumento());
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((musico == null) ? 0 : musico.hashCode());
		result = prime * result + (sonando ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instrumento other = (Instrumento) obj;
		if (musico == null) {
			if (other.musico != null)
				return false;
		} else if (!musico.equals(other.musico))
			return false;
		if (sonando != other.sonando)
			return false;
		return true;
	}
	
}
