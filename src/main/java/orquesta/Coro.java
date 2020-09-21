package orquesta;

import java.util.Scanner;

public class Coro extends Cantante {
	private TipoCoro tipo;
	
	public Coro() {
		super();
		leerTipoCoro();
	}

	public Coro(String nombre, Genero genero, TipoCoro tipo) {
		super(nombre, genero);
		this.tipo = tipo;
	}

	public TipoCoro getTipo() {
		return tipo;
	}

	public void setTipo(TipoCoro tipo) {
		this.tipo = tipo;
	}
	
	public void leerTipoCoro() {
    	Menu menu = new Menu();
    	if (menu.escoger("Introduzca Tipo, 1: Baritono, 2: Bajo? ") == 1) {
    		this.tipo = TipoCoro.BARITONO;
    	} else {
    		this.tipo = TipoCoro.BAJO;
    	}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Coro: [nombre=");
		sb.append(this.getNombre());
		sb.append(", tipo=");
		sb.append(getTipo() + "]");
		return sb.toString();
	}

	@Override
	public boolean sonar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean noSonar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coro other = (Coro) obj;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
}
