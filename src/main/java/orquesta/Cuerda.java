package orquesta;

import java.util.Scanner;

public class Cuerda extends Instrumento {
	
	String nombreInstrumentoCuerda;
	
	public Cuerda() {
		leer();
	}
	
	public Cuerda(Persona musico, String nombreInstrumentoCuerda) {
		super(musico);
		this.nombreInstrumentoCuerda = nombreInstrumentoCuerda.toLowerCase();
	}
	
	public void leer() {
    	System.out.print("Introduzca Instrumento? ");
        Scanner sc = new Scanner(System.in);
        try {
    		if (sc.hasNextLine()) {
    			this.nombreInstrumentoCuerda = sc.nextLine().toLowerCase();
    		}
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


	@Override
	public String getNombreInstrumento() {
		return this.nombreInstrumentoCuerda;
	}

	@Override
    public int compareTo(Instrumento t) {
        return this.getNombreInstrumento().compareTo(t.getNombreInstrumento());
    }	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Cuerda: [musico=");
		sb.append(this.getMusico().getNombre());
		sb.append(", nombreInstrumentoCuerda=");
		sb.append(getNombreInstrumento());
		sb.append("]");
		return sb.toString();
	}

}
