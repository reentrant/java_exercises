package reproductor;

import java.util.Objects;

public class DVD extends Video {

    private Tiempo duracion;
    private int numero;

    DVD() {
        this.numero = ++contadorDVD;
        this.duracion = new Tiempo();
    }

    /**
     *
     * @return Para un DVD devuelve el tiempo de duracion.
     */
    @Override
    public Tiempo duracionTotal() {
        return duracion;
    }

    /**
     *
     * @return Para un DVD devuelve 1.
     */
    @Override
    public int numeroDePistas() {
        return 1;
    }

    /**
     * @return the numero
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
        final DVD other = (DVD) obj;

        return this.duracion.equals(other.duracion)
                && super.equals(other);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.duracion);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DVD {[");
        sb.append(numero);
        sb.append("], [");
        sb.append(fecha);
        sb.append("], ");
        sb.append(numeroDePistas());
        sb.append(" pelicula, ");
        sb.append(super.toString());
        sb.append(", duracion: ");
        sb.append(duracionTotal());
        sb.append("}");
        return sb.toString();
    }
}
