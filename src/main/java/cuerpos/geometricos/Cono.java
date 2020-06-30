package cuerpos.geometricos;

/**
 * Clase Cono. No tiene atributos propios. Clase de la que crearemos los objetos
 * de tipo Cono.
 */
class Cono extends CuerpoGeometricoCircular {

    Cono() {
        nombre = "Cono";
    }
    
    @Override
    public double area() {
        double areaCono = getCirculoBase().calcularArea() * Math.PI
                * getCirculoBase().getRadio() * getGeneratriz();
        return areaCono;
    }

    @Override
    public double volumen() {
        double volumenCono = getCirculoBase().calcularArea() * getAltura() / 3.0;
        return volumenCono;
    }

}
