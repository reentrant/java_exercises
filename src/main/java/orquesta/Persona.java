package orquesta;

import java.util.Scanner;

import cuerpos.geometricos.Colores;

public class Persona {
	private String nombre;
	private Genero genero;

	public Persona() {
		leer();
	}
	
	public Persona(String nombre, Genero genero) {
		this.setNombre(nombre);
		this.setGenero(genero);
	}
	
    public void leer() {
    	System.out.print("Introduzca nombre? ");
        Scanner sc = new Scanner(System.in);
        try {
    		if (sc.hasNextLine()) {
    			this.nombre = sc.nextLine();
    		}
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        int tipo = -1;
        System.out.print("Introduzca genero, 1: Hombre, 2: Mujer? ");
    	try {
        	if (sc.hasNextLine()) {
        		String string = sc.nextLine();
        		tipo = Integer.parseInt(string);
        	}
		}
    	catch (Exception e) {
            System.out.println(e.getMessage());
        }	
        if (tipo > 0 && tipo < 3)
        	this.genero = Genero.values()[tipo - 1];
        //sc.close();
    }

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	private void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public Genero getGenero() {
		return genero;
	}

	public String getNombre() {
		return nombre;
	}
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona: [nombre=");
        sb.append(getNombre());
        sb.append(", Genero= ");
        sb.append(getGenero());
        sb.append("]");
        return sb.toString();
    }

	
	public static void main(String [] args) {
		Persona p = new Persona();
		System.out.println(p);
		Persona q = new Persona();
		System.out.println(q);
	}
}
