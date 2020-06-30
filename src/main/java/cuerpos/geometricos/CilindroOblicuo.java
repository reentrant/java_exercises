package cuerpos.geometricos;

/**
 * Clase CilindroOblicuo. No tiene atributos propios. Clase de la que crearemos
 * los objetos de tipo CilindroOblicuo.
 */
public class CilindroOblicuo extends Cilindro {

    CilindroOblicuo() {
        nombre = "Cilindro Oblicuo";
    }
    
    @Override
    public double area() {
        double areaCilindro = 2 * Math.PI * getCirculoBase().getRadio() * getGeneratriz();
        return areaCilindro;
    }

    @Override
    public double volumen() {
        double volumenCilindro = getCirculoBase().calcularArea() * getAltura();
        return volumenCilindro;
    }

}
