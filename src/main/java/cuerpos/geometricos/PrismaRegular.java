package cuerpos.geometricos;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Clase PrismaRegular. Clase Abstracta. Contiene el atributo lado. Contiene el valor de uno de los
 * lados de la base del prisma. Como se trata de prismas regulares, todos los lados de la base miden
 * lo mismo. 
 */
abstract class PrismaRegular extends CuerpoGeometrico {

    private double lado;

    public PrismaRegular() {
    }

    public PrismaRegular(double lado, double altura, Colores color) {
        super(altura, color);
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public void leer() {
        super.leer(); 
        Scanner sc = new Scanner(System.in);
        do { 
            System.out.print("Lado: ");
            lado = sc.nextDouble();
        } while (lado <= 0);
        sc.close();
    }

    @Override
    public int hashCode() {

        int hash = 5;
        return hash;
    }

    //El metodo equals en esta clase actua de la siguiente forma:
    //Se comprueba el valor del atributo de la clase: el valor de lado.
    //Si el valor del lado es distinto devuelve false, indicando que los objetos que esta comparando son distintos
    //Si el valor del lado es igual NO devuelve true. Hay que comprobar el resto de atributos.
    //Para eso se hace una llamada al equals de la clase base
    //El equals de la clase base comprueba los valores de color y altura y devuelve true o false. 
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PrismaRegular other = (PrismaRegular) obj;
        if (Double.doubleToLongBits(this.lado) != Double.doubleToLongBits(other.lado)) {
            return false; //si el lado es distinto los objetos no son iguales
        }
        return super.equals(other); //si el lado es igual se devuelve el resultado de comparar el color y la altura
    }

    @Override
    public String toString() {
        DecimalFormat dosDecimales = new DecimalFormat("#.00");
        StringBuilder sb = new StringBuilder();
        sb.append("CuerpoGeometrico{");
        sb.append(nombre);
        sb.append(super.toString());
        sb.append(", Lado: ");
        sb.append(this.lado);
        sb.append(", Area: ");
        sb.append(dosDecimales.format(this.area())); 
        sb.append(", Volumen: ");
        sb.append(dosDecimales.format(this.volumen()));
        sb.append("}");
        return sb.toString();
    }
}
