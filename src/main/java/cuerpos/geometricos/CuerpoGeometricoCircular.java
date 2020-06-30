package cuerpos.geometricos;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Clase CuerpoGeometricoCircular.
 *
 * Clase Abstracta. Contiene los atributos circuloBase y generatriz. El atributo circuloBase es de
 * tipo Circulo. Representa el círculo que forma la base del cuerpo. El atributo generatriz contiene
 * el valor de la generatriz del cuerpo.
 */
abstract class CuerpoGeometricoCircular extends CuerpoGeometrico {
    
    private Circulo circuloBase;
    private double generatriz;

    CuerpoGeometricoCircular() {
    }

    CuerpoGeometricoCircular(Circulo circuloBase, double generatriz) {
        this.circuloBase = circuloBase;
        this.generatriz = generatriz;
    }
    
    /**
     * @return the circuloBase
     */
    public Circulo getCirculoBase() {
        return circuloBase;
    }

    /**
     * @param circuloBase the circuloBase to set
     */
    public void setCirculoBase(Circulo circuloBase) {
        this.circuloBase = circuloBase;
    }

    /**
     * @return the generatriz
     */
    public double getGeneratriz() {
        return generatriz;
    }

    /**
     * @param generatriz the generatriz to set
     */
    public void setGeneratriz(double generatriz) {
        this.generatriz = generatriz;
    }

    /**
     * metodo leer para introducir por teclado el valor del lado.
     */
    public void leer() {
        super.leer();
        System.out.println("leer radio de círculo base");
        Scanner scanner = new Scanner(System.in);
        this.setCirculoBase(new Circulo(scanner.nextDouble()));
        System.out.println("leer generatriz");
        this.setGeneratriz(scanner.nextDouble());
        scanner.close();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CuerpoGeometricoCircular other = (CuerpoGeometricoCircular) obj;

        if (this.getCirculoBase() != other.getCirculoBase()) {
            return false;
        }
        if (this.getGeneratriz() != other.getGeneratriz()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        DecimalFormat dosDecimales = new DecimalFormat("#.00");
        StringBuilder sb = new StringBuilder();
        sb.append("CuerpoGeometrico{");
        sb.append(nombre);
        sb.append(super.toString());
        sb.append(", altura: ");
        sb.append(getAltura());
        sb.append(", radio Circulo Base=");
        sb.append(getCirculoBase().getRadio());
        sb.append(", Generatriz=");
        sb.append(getGeneratriz());
        sb.append(", Area: ");
        sb.append(dosDecimales.format(this.area())); 
        sb.append(", Volumen: ");
        sb.append(dosDecimales.format(this.volumen())); ///
        sb.append("}");
        return sb.toString();
    }
}
