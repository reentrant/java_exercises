package cuerpos.geometricos;

/**
 * Clase PrismaRegularTriangular. No tiene atributos propios. Clase de la que
 * crearemos los objetos de tipo PrismaRegularTriangular.
 */
class PrismaRegularTriangular extends PrismaRegular {
    
    PrismaRegularTriangular() {
        nombre = "Prisma Regular Triangular";
    }

    PrismaRegularTriangular(double lado, double altura, Colores color) {
        super(lado, altura, color);
        nombre = "Prisma Regular Triangular";
    }

    @Override
    public double area() {
        double areaPrisma = getLado() * (getLado() * Math.sqrt(3) / 2 + 3 * getAltura());
        return areaPrisma;
    }

    @Override
    public double volumen() {
        double volumenPrisma = Math.sqrt(3) * this.getLado() * this.getLado() * getAltura() / 4;
        return volumenPrisma;
    }
    
}
