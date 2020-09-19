package orquesta;

public class Cuerda extends Instrumento {
	
	String nombreInstrumentoCuerda;

	public Cuerda(Persona musico, String nombreInstrumentoCuerda) {
		super(musico);
		this.nombreInstrumentoCuerda = nombreInstrumentoCuerda;
	}

	@Override
	public String getNombreInstrumento() {
		return this.nombreInstrumentoCuerda;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Cuerda: [");
		sb.append(super.toString());
		sb.append(", nombreInstrumentoCuerda=");
		sb.append(getNombreInstrumento());
		sb.append("]");
		sb.append("]");
		return sb.toString();
	}
}
