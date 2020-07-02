package reproductor;

import java.util.Objects;

abstract class Multimedia {

    protected Fecha fecha;
    public static int contadorCD = 0;
    public static int contadorDVD = 0;
    public static int contadorBR = 0;
    
    public abstract Tiempo duracionTotal();
    
    public abstract int numeroDePistas();
    
    
    @Override
    public boolean equals(Object obj) {
        
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        }
        final Multimedia other = (Multimedia) obj;
         
        return this.fecha.equals(other.fecha);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.fecha);
        return hash;
    }
    

}
