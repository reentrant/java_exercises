package orquesta;

public abstract class Instrumento {

	private Persona musico;
	private boolean sonando;
	
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
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[musico=");
		sb.append(getMusico());
		sb.append(", sonando=");
		sb.append(getSonando());
		sb.append("]");
		return sb.toString();
	}
}
