package cuerpos.geometricos;

import java.util.Scanner;

/**
 *
 * Clase CuerpoGeometrico. Clase Abstracta. Contiene los atributos color y altura. El atributo color
 * es un enum con 4 valores posibles: AZUL, BLANCO, ROJO, VERDE. Cuando se crea un cuerpo geometrico
 * se indicara de que color es. El atributo altura indica la altura del cuerpo geometrico. Esta
 * clase contendra un metodo leer para introducir por teclado ambos valores. Esta clase contendra
 * los metodos abstractos area() y volumen() que permitan calcular el area y el volumen de los
 * cuerpos geometricos
 */
public abstract class CuerpoGeometrico implements Comparable<CuerpoGeometrico> {

    protected String nombre;
    private Colores color;
    private double altura;

    public CuerpoGeometrico() {
        leer();
    }

    public CuerpoGeometrico(double altura, Colores color) {
        this.altura = altura;
        this.color = color;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Colores getColor() {
        return color;
    }

    public void setColor(Colores color) {
        this.color = color;
    }

    //Método para leer los atributos de la clase
    public void leer() {
        Scanner sc = new Scanner(System.in);
        int tipo;
        do {
            System.out.print("Color 1-> AZUL 2-> BLANCO 3-> ROJO 4-> VERDE: ");
            tipo = sc.nextInt();
        } while (tipo < 1 || tipo > 4);
        this.color = Colores.values()[tipo - 1];

        do {
            System.out.print("Altura: ");
            altura = sc.nextDouble();
        } while (altura <= 0);
        sc.close();
    }

//    Implement the equals() and hashCode() methods
//    to maximize performance when storing objects of this type in a HashMap
    @Override
    public int hashCode() {
        int hash = 7;
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
        final CuerpoGeometrico other = (CuerpoGeometrico) obj;

        /*
        El primer if utiliza el metodo doubleToLongBits de la clase Double y sirve para
        realizar la comprobacion con mayor precision, en el caso de que el valor a comprobar,
        en este caso la altura, tuviese una cantidad muy grande de cifras decimales.
        
        if (Double.doubleToLongBits(this.altura) != Double.doubleToLongBits(other.altura)) {
            return false;
        }
        
        Por otro lado, ya que la altura seguramente no tendra demasiadas cifras decimales:
  
        if (this.altura != other.altura) {
            return false;
        }
         */
        if (Double.doubleToLongBits(this.altura)
                != Double.doubleToLongBits(other.altura)) {
            return false;
        }
        return this.color == other.color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", Color ");
        sb.append(color);
        sb.append(", Altura: ");
        sb.append(altura);
        return sb.toString();
    }

    //metodos abstractos
    public abstract double area();

    public abstract double volumen();

    @Override
    public int compareTo(CuerpoGeometrico t) {
        return this.color.compareTo(t.color);
    }

}
