package reproductor;

public class Fecha {
	private int dia;
	private int mes;
	private int year;

	Fecha(int dia, int mes, int year) {
		this.dia = dia;
		this.mes = mes;
		this.year = year;
	}

	/**
	 * @return dia
	 */
	public int getDia() {
		return dia;
	}

	/**
	 * @param dia
	 */
	public void setDia(int dia) {
		this.dia = dia;
	}

	/**
	 * @return mes
	 */
	public int getMes() {
		return mes;
	}

	/**
	 * @param mes
	 */
	public void setMes(int mes) {
		this.mes = mes;
	}

	/**
	 * @return año
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param año
	 */
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Fecha other = (Fecha) obj;
		return this.year == other.year && this.mes == other.mes && this.dia == other.dia;
	}

	@Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.dia;
        hash = 97 * hash + this.mes;
        hash = 97 * hash + this.year;
        return hash;
    }

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (dia != 0 || mes != 0) {
            sb.append(dia);
            sb.append("/");
            sb.append(mes);
            sb.append("/");
        }
        sb.append(year);
        return sb.toString();
    }
}