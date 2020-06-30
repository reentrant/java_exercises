package cuerpos.geometricos;

/**
 * Clase Circulo.
 *
 * Contiene el atributo radio. Esta clase contendrá un método calcularArea()
 * para calcular el área del circulo correspondiente.
 */
class Circulo {

    private double radio;

    Circulo(double radio) {
        this.radio = radio;
    }
    
    /**
     * @return the radio
     */
    public double getRadio() {
        return radio;
    }

    /**
     * @param radio the radio to set
     */
    public void setRadio(double radio) {
        this.radio = radio;
    }

    double calcularArea() {
        return Math.PI * getRadio() * getRadio();
    }
}
