package reproductor;

import java.util.Scanner;

public final class Tiempo {

	private int minutos;
	private int segundos;
	private int horas;

	Tiempo() {
		this.horas = 0;
		System.out.println("Cual es la duracion en minutos y segundos?");
		System.out.println("Introduzca los minutos");
		Scanner scanner = new Scanner(System.in);
		this.minutos = scanner.nextInt();
		System.out.println("Introduzca los segundos");
		this.segundos = scanner.nextInt();
		ajustarHoras();
		scanner.close();
	}

	Tiempo(int minutos, int segundos) {
		this.horas = 0;
		this.minutos = minutos;
		this.segundos = segundos;
		ajustarHoras();
	}

	public void ajustarHoras() {
		if (this.minutos > 59) {
			this.horas = this.minutos / 60;
			this.minutos = this.minutos % 60;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Tiempo other = (Tiempo) obj;

		return this.minutos == other.minutos && 
				this.segundos == other.segundos && 
				this.horas == other.horas;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 17 * hash + this.minutos;
		hash = 17 * hash + this.segundos;
		hash = 17 * hash + this.horas;
		return hash;
	}

	public int getDuracionSegundos() {
		return 3600 * getHoras() + getMinutos() * 60 + getSegundos();
	}

	/**
	 * @return horas
	 */
	public int getHoras() {
		return horas;
	}

	/**
	 * @return minutos
	 */
	public int getMinutos() {
		return minutos;
	}

	/**
	 * @return segundos
	 */
	public int getSegundos() {
		return segundos;
	}

	/**
	 * @param minutos
	 */
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	/**
	 * @param segundos
	 */
	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (getHoras() > 0) {
			sb.append(horas);
			sb.append(":");
		}
		sb.append(minutos);
		sb.append(":");
		sb.append(segundos);
		return sb.toString();
	}
}
