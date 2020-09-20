package orquesta;

import java.util.Scanner;

public class Viento extends Instrumento {

	private String nombreInstrumentoViento;
	
	public Viento() {
		leer();
	}
	
	public Viento(Persona musico, String nombreInstrumentoViento) {
		super(musico);
		this.nombreInstrumentoViento = nombreInstrumentoViento;
	}
	
	
	public void leer() {
		System.out.print("Nombre del Instrumento de Viento? ");
        Scanner sc = new Scanner(System.in);
        try {
    		if (sc.hasNextLine()) {
    			this.nombreInstrumentoViento = sc.nextLine();
    		}
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //sc.close();
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
