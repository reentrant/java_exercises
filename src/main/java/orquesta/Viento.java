package orquesta;

public class Viento extends Instrumento {

	private String nombreInstrumentoViento;
	
	public Viento(Persona musico, String nombreInstrumentoViento) {
		super(musico);
		this.nombreInstrumentoViento = nombreInstrumentoViento;
	}

	@Override
	public String getNombreInstrumento() {
		return this.nombreInstrumentoViento;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Viento: [");
		sb.append(super.toString());
		sb.append(", nombreInstrumentoViento=");
		sb.append(getNombreInstrumento());
		sb.append("]");
		sb.append("]");
		return sb.toString();
	}

}
