package orquesta;

import java.util.Scanner;

public class Viento extends Instrumento {

	private String nombreInstrumentoViento;
	
	public Viento() {
		leer();
	}
	
	public Viento(Persona musico, String nombreInstrumentoViento) {
		super(musico);
		this.nombreInstrumentoViento = nombreInstrumentoViento.toLowerCase();
	}
	
	
	public void leer() {
		System.out.print("Nombre del Instrumento de Viento? ");
        Scanner sc = new Scanner(System.in);
        try {
    		if (sc.hasNextLine()) {
    			this.nombreInstrumentoViento = sc.nextLine().toLowerCase();
    		}
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
	}

	@Override
	public String getNombreInstrumento() {
		return this.nombreInstrumentoViento;
	}

	@Override
    public int compareTo(Instrumento t) {
        return this.getNombreInstrumento().compareTo(t.getNombreInstrumento());
    }	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Viento: [musico=");
		sb.append(this.getMusico().getNombre());
		sb.append(", nombreInstrumentoViento=");
		sb.append(getNombreInstrumento());
		sb.append("]");
		return sb.toString();
	}

}
