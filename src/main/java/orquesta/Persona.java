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
    	System.out.print("Introduzca nombre de la persona. ");
        Scanner sc = new Scanner(System.in);
        try {
    		if (sc.hasNextLine()) {
    			this.nombre = sc.nextLine();
    		}
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        Menu menu = new Menu();
        if (menu.escoger("Introduzca genero, 1: Hombre, 2: Mujer? ") == 1) {
        	this.genero = Genero.HOMBRE;
        } else {
        	this.genero = Genero.MUJER;
        }
    	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Persona other = (Persona) obj;
		if (genero != other.genero)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	public static void main(String [] args) {
		Persona p = new Persona();
		System.out.println(p);
		Persona q = new Persona();
		System.out.println(q);
	}
}
