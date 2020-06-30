package cuerpos.geometricos;

import java.util.Scanner;

/**
 * Clase TroncoDeCono. Contiene el atributo circuloMenor de tipo Circulo.
 * 
 */
class TroncoDeCono extends Cono {

    private Circulo circuloMenor;

    TroncoDeCono() {
        System.out.println("Leer radio de circulo menor");
        Scanner scanner = new Scanner(System.in);
        nombre = "Tronco de Cono";
        circuloMenor = new Circulo(scanner.nextDouble());
        scanner.close();
    }
    
    @Override
    public int hashCode() {
        int hash = 9;
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
        final TroncoDeCono other = (TroncoDeCono) obj;

        if (this.getCirculoMenor() != other.getCirculoMenor()) {
            return false;
        }
        return true;
    }

    /**
     * @return the circuloMenor
     */
    public Circulo getCirculoMenor() {
        return circuloMenor;
    }

    /**
     * @param circuloMenor the circuloMenor to set
     */
    public void setCirculoMenor(Circulo circuloMenor) {
        this.circuloMenor = circuloMenor;
    }

    
    @Override
    public double area() {
        double areaTronco = getCirculoBase().calcularArea()
                + getCirculoMenor().calcularArea()
                + Math.PI * (getCirculoBase().getRadio() 
                + getCirculoMenor().getRadio()) * getGeneratriz();
        return areaTronco;
    }
    
    @Override
    public double volumen() {
        double volumenTronco = Math.PI * getAltura()
                * (Math.pow(getCirculoBase().getRadio(), 2.0)
                + Math.pow(getCirculoMenor().getRadio(), 2.0)
                + getCirculoBase().getRadio() * getCirculoMenor().getRadio()) / 3.0;
        return volumenTronco;
    }
}
