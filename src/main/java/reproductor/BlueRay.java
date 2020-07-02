package reproductor;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class BlueRay extends Video {

    private boolean serie;  // Solo tendremos series en BlueRay.
    private boolean tresD;  // de tipo boolean indica si es en 3D o no.
    private int numero;     // numero asignado cuando se crea del BR.
    private int temporadas = 1;
    private ArrayList<Tiempo> duracion;  // Contiene la duracion del BlueRay.

    BlueRay() {
        Scanner scanner = new Scanner(System.in);
        this.numero = ++contadorBR;
        System.out.println("Dado que solo tenemos series en BlueRay, ");
        this.serie = true;
        System.out.println("Cuantas temporadas tiene?");
        this.temporadas = scanner.nextInt();
        duracion = new ArrayList<>();
        for (int i = 0; i < temporadas; i++) {
            System.out.print("Introduzca la duracion de la temporada ");
            System.out.print(i + 1 + ". ");
            duracion.add(new Tiempo());
        }
        scanner.close();
    }

    /**
     *
     * @return Para un BlueRay, si es una serie devuelve la suma del tiempo total de todas las
     * temporadas. Si no es una serie devuelve la duración de la película.
     */
    @Override
    public Tiempo duracionTotal() {
        int totalDeSegundos = 0;
        if (isSerie()) {
            // si es una serie devuelve la suma del tiempo total de todas las temporadas.
            for (Tiempo t : duracion) {
                totalDeSegundos += t.getDuracionSegundos();
            }
        } else {
            // Solo tendremos series en BlueRay.  
        }
        int minutos = totalDeSegundos / 60;
        int segundos = totalDeSegundos % 60;
        return new Tiempo(minutos, segundos);
    }

    /**
     *
     * @return Para un BR si es una serie devuelve el número de temporadas ó 1 si no es una serie.
     */
    @Override
    public int numeroDePistas() {
        if (isSerie()) {
            return getTemporadas();
        } else {
            return 1;
        }
    }

    /**
     * @return número de temporadas
     */
    public int getTemporadas() {
        return temporadas;
    }

    /**
     * @param temporadas
     */
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    /**
     * @return si es una serie
     */
    public boolean isSerie() {
        return serie;
    }

    /**
     * @param serie
     */
    public void setSerie(boolean serie) {
        this.serie = serie;
    }

    /**
     * @return si 3D
     */
    public boolean isTresD() {
        return tresD;
    }

    /**
     * @param tresD
     */
    public void setTresD(boolean tresD) {
        this.tresD = tresD;
    }

    /**
     * @return numero de BlueRay
     */
    public int getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BlueRay other = (BlueRay) obj;

        if (this.duracion.size() != other.duracion.size()) {
            return false;
        }

        return this.serie == other.serie
                && this.temporadas == other.temporadas
                && this.tresD == other.tresD
                && super.equals(other);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (this.serie ? 1 : 0);
        hash = 41 * hash + (this.tresD ? 1 : 0);
        hash = 41 * hash + this.temporadas;
        hash = 41 * hash + Objects.hashCode(this.duracion);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Blue Ray {[");
        sb.append(getNumero());
        sb.append("],");
        sb.append(super.toString());
        sb.append(", [");
        sb.append(fecha);
        sb.append("],");
        sb.append(numeroDePistas());
        sb.append(" temporadas, duracion: ");
        sb.append(duracionTotal());
        sb.append("}");
        return sb.toString();
    }

    public int compareTo(BlueRay o) {
        return this.getTemporadas() - o.getTemporadas();
    }

}
