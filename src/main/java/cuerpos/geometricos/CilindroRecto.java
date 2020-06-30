package cuerpos.geometricos;

/**
 * Clase CilindroRecto. No tiene atributos propios. Clase de la que crearemos
 * los objetos de tipo CilindroRecto. En estos objetos el valor de la generatriz
 * coincide con el valor de la altura
 */
public class CilindroRecto extends Cilindro {

    CilindroRecto() {
        nombre = "Cilindro Recto";
    }

    @Override
    public double area() {
        double areaCilindro = 2 * Math.PI * getCirculoBase().getRadio() * getAltura()
                + 2 * getCirculoBase().calcularArea();
        return areaCilindro;
    }

    @Override
    public double volumen() {
        double volumenCilindro = getCirculoBase().calcularArea() * getAltura();
        return volumenCilindro;
    }

}
