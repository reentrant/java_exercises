package orquesta;

import java.util.Scanner;

public class Cuerda extends Instrumento {
	
	String nombreInstrumentoCuerda;
	
	public Cuerda() {
		leer();
	}
	
	public Cuerda(Persona musico, String nombreInstrumentoCuerda) {
		super(musico);
		this.nombreInstrumentoCuerda = nombreInstrumentoCuerda;
	}
	
	public void leer() {
    	System.out.print("Introduzca Instrumento? ");
        Scanner sc = new Scanner(System.in);
        try {
    		if (sc.hasNextLine()) {
    			this.nombreInstrumentoCuerda = sc.nextLine();
    		}
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //sc.close();
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
