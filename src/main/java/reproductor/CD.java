package reproductor;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

public class CD extends Multimedia {

    private Cancion[] cd;
    private int indice;
    private int numero;

    CD(Cancion[] arregloDeCanciones) {
        this.cd = arregloDeCanciones;
        this.numero = ++contadorCD;
        setFecha();
    }

    /**
     * duracionTotal().
     */
    @Override
    public Tiempo duracionTotal() {

        int totalDeSegundos = 0;
        for (Cancion cancion : this.cd) {
            totalDeSegundos += cancion.getDuracion();
        }
        int minutos = totalDeSegundos / 60;
        int segundos = totalDeSegundos % 60;
        return new Tiempo(minutos, segundos);
    }

    /**
     * numeroDePistas().
     *
     * @return Para un CD devuelve el numero de canciones que contiene.
     */
    @Override
    public int numeroDePistas() {
        return cd.length;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CD other = (CD) obj;

        if (this.cd == null || other.cd == null) {
            return false;
        } else {
            return Arrays.equals(this.cd, other.cd);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Arrays.deepHashCode(this.cd);
        hash = 89 * hash + this.indice;
        hash = 89 * hash + this.numero;
        return hash;
    }

    /**
     * @return cd: es un array de Canciones.
     */
    public Cancion[] getCd() {
        return cd;
    }

    /**
     * @param cd
     */
    public void setCd(Cancion[] cd) {
        this.cd = cd;
    }

    /**
     * @return indice: Sirve de indice para el acceso a los elementos del array.
     */
    public int getIndice() {
        return indice;
    }

    /**
     * @param indice
     */
    public void setIndice(int indice) {
        this.indice = indice;
    }

    /**
     * @return numero: numero de CD. A cada CD creado se le asigna un numero consecutivo comenzando
     * por 1.
     */
    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Compact Disc [");
        sb.append(numero);
        sb.append("], [");
        sb.append(fecha);
        sb.append("], numero de pistas: ");
        sb.append(numeroDePistas());
        sb.append(", duracion total: ");
        sb.append(duracionTotal());
        sb.append(" {");
        sb.append(Arrays.toString(getCd()));
        sb.append("}");
        return sb.toString();
    }

    private void setFecha() {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        this.fecha = new Fecha(localDate.getDayOfMonth(),
                localDate.getMonthValue(),
                localDate.getYear());
    }
}
