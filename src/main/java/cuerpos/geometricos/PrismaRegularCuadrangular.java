package cuerpos.geometricos;

/**
 * Clase PrismaRegularCuadrangular. No tiene atributos propios. Clase de la que crearemos los
 * objetos de tipo PrismaRegularCuadrangular.
 */
class PrismaRegularCuadrangular extends PrismaRegular {

    public PrismaRegularCuadrangular() {
        this.nombre = "Prisma Regular Cuadrangular";
    }

    PrismaRegularCuadrangular(double lado, double altura, Colores color) {
        super(lado, altura, color);
        this.nombre = "Prisma Regular Cuadrangular";
    }

    @Override
    public double area() {
        double areaPrisma = 2 * getLado() * (getLado() + 2 * getAltura());
        return areaPrisma;
    }

    @Override
    public double volumen() {
        double volumenPrisma = getLado() * getLado() * getAltura();
        return volumenPrisma;
    }

}
